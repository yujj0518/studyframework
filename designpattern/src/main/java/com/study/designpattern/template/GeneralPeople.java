package com.study.designpattern.template;

/**
 * 普通人跑步的速度
 */
public class GeneralPeople extends People{
    @Override
    public void runSpead() {
        System.out.println("普通人跑步速度：600s/km");
    }
}
