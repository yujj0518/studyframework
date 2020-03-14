package com.study.designpattern.template;

/**
 *
 */
public class Player {

    public void runSpead(){
        new People() {
            @Override
            public void runSpead() {
                System.out.println("长跑运动员跑步速度：100s/km");
            }
        }.runSpead();
    }
}
