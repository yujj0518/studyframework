package com.study.designpattern.factory.method;

public class FactoryMethodTest {
    public static void main(String[] args) {
        IPayFactory payFactory = new ApplePayFactory();
        payFactory.create().pay();
    }
}
