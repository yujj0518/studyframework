package com.study.designpattern.factory;

public class ApplePay implements IPay {
    @Override
    public void pay() {
        System.out.println("苹果支付");
    }
}