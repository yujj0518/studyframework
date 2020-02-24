package com.study.designpattern.factory;

public class WechatPay implements IPay {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}