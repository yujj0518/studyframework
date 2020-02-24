package com.study.designpattern.factory.simple;

import com.study.designpattern.factory.AliPay;
import com.study.designpattern.factory.IPay;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        IPay iPay = PayFactory.create(AliPay.class);
        iPay.pay();
    }
}
