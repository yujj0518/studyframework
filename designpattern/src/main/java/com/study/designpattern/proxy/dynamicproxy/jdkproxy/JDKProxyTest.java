package com.study.designpattern.proxy.dynamicproxy.jdkproxy;

import com.study.designpattern.proxy.IPerson;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;


public class JDKProxyTest {

    public static void main(String[] args) throws Exception {
        IPerson proxy = (IPerson) new JDKMeipo().getInstance(new Girl());

        proxy.findLove();

        //通过反编译工具查看代码
        byte[] by = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IPerson.class});
        FileOutputStream fos = new FileOutputStream(new File("/Users/yujj/workroom/testcode/$Proxy0.class"));
        fos.write(by);
        fos.close();
    }
}
