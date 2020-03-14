package com.study.designpattern.template;

public class TemplateTest {
    public static void main(String[] args) {
        GeneralPeople generalPeople = new GeneralPeople();
        generalPeople.runSpead();

        Player player = new Player();
        player.runSpead();
    }
}
