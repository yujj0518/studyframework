package com.study.designpattern.factory.abst;


public class AbstractFactoryTest {
    public static void main(String[] args) {
        IPayFactory payFactory = new ApplePayFactory();
        payFactory.startRequest().request();
        payFactory.endCallback().callback();

    }
}
