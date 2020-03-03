package com.study.designpattern.proxy.dynamicproxy.gpproxy;

import com.study.designpattern.proxy.IPerson;
import com.study.designpattern.proxy.dynamicproxy.jdkproxy.Girl;


public class GpProxyTest {
    public static void main(String[] args) {
        IPerson proxy = (IPerson) new GpMeipo().getInstance(new Girl());
        proxy.findLove();
        proxy.findLoveParam("我是有条件的");
    }
}
