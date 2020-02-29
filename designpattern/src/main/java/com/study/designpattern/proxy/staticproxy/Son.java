package com.study.designpattern.proxy.staticproxy;

import com.study.designpattern.proxy.IPerson;

public class Son implements IPerson {
    @Override
    public void findLove() {
        System.out.println("儿子找对象：肤白貌美大长腿！");
    }
}
