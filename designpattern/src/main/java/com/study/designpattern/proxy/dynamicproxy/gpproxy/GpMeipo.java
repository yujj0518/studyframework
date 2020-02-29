package com.study.designpattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

public class GpMeipo implements GpInvocationHandler {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return GpProxy.newProxyInstance(new GpClassLoader(),this.target.getClass().getInterfaces(),this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆开始准备工作~~~~");
        Object object = method.invoke(target,args);
        System.out.println("完成~~~~");
        return object;
    }
}
