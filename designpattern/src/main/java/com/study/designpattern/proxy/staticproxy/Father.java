package com.study.designpattern.proxy.staticproxy;

import com.study.designpattern.proxy.IPerson;

public class Father implements IPerson {

    private IPerson target;

    public Father(IPerson target) {
        this.target = target;
    }

    @Override
    public void findLove() {
        System.out.println("开始给儿子找对象~~~~");
        target.findLove();
        System.out.println("找好了，准备结婚~~~~");
    }

    @Override
    public void findLoveParam(String condition) {

    }
}
