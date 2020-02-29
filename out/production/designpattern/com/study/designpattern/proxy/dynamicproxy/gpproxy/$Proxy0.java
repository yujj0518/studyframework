package com.study.designpattern.proxy.dynamicproxy.gpproxy;

import com.study.designpattern.proxy.IPerson;

import java.lang.reflect.*;

public final class $Proxy0 implements com.study.designpattern.proxy.IPerson {
    GpInvocationHandler h;

    public $Proxy0(GpInvocationHandler h) {
        this.h = h;
    }

    public void findLove() {
        try {
            Method m = com.study.designpattern.proxy.IPerson.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
