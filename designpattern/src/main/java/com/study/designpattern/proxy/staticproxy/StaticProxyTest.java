package com.study.designpattern.proxy.staticproxy;

import com.study.designpattern.proxy.IPerson;

/**
 * 静态对象就是要求代理对象和被代理对象都要实现同一个接口或者继承类
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        //父亲就是一个代理类
        IPerson target = new Father(new Son());
        target.findLove();
    }
}
