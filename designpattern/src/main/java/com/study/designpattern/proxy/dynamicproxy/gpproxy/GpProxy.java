package com.study.designpattern.proxy.dynamicproxy.gpproxy;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GpProxy {

    public static final String ln = "\r\n";


    public static Object newProxyInstance(GpClassLoader loader,
                                          Class<?>[] interfaces,
                                          GpInvocationHandler h) {

        //生成源代码java类文件
        String src = generateSrc(interfaces);
        System.out.println(src);

        //Java 文件输出磁盘
        String filepath = GpProxy.class.getResource("").getPath();
        File file = new File(filepath+"$Proxy0.java");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();

            //编译class类文件（重写GpClassLoader类加载器）
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //编译生成的.class 文件加载到 JVM 中来
            Class clazz = loader.findClass("$Proxy0");
            Constructor c = clazz.getConstructor(GpInvocationHandler.class);
            file.delete();
            //字节码重组新对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.study.designpattern.proxy.dynamicproxy.gpproxy;" + ln);
        sb.append("import com.study.designpattern.proxy.IPerson; " + ln);
        sb.append("import java.lang.reflect.*; " + ln);
        sb.append("public final class $Proxy0 implements " + interfaces[0].getName() + " {" + ln);
        sb.append("GpInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GpInvocationHandler h) {" + ln);
        sb.append("this.h=h;" + ln);
        sb.append("}" + ln);
        for (Method method : interfaces[0].getMethods()) {
            Class<?>[] params = method.getParameterTypes();
            StringBuffer paramClasses = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramNames = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\""
                    + method.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(method.getReturnType()) ? "return " : "") +
                    getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", method.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(method.getReturnType()));
            sb.append("}" + ln);
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    private static Map<Class, Class> mappings = new HashMap<Class, Class>();

    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
