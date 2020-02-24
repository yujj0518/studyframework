package com.study.designpattern.factory.simple;

import com.study.designpattern.factory.IPay;

public class PayFactory {
    public static IPay create(Class<? extends IPay> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
