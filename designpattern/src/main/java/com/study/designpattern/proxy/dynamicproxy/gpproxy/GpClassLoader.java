package com.study.designpattern.proxy.dynamicproxy.gpproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GpClassLoader extends ClassLoader {
    private File classFilePath;

    public GpClassLoader() {
        String path = GpClassLoader.class.getResource("").getPath();
        this.classFilePath = new File(path);
    }

    public Class findClass(String name) {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        String className = GpClassLoader.class.getPackage().getName() + "." + name;
        if (classFilePath != null) {
            File classFile = new File(classFilePath,name.replace("\\.","/") + ".class");
            if (classFile.exists()) {

                try {
                    fis = new FileInputStream(classFile);
                    baos = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len =fis.read(bytes))!=-1) {
                        baos.write(bytes,0,len);
                    }

                    return defineClass(className,baos.toByteArray(),0,baos.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
