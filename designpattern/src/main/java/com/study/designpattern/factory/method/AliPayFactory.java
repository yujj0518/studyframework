package com.study.designpattern.factory.method;

import com.study.designpattern.factory.AliPay;
import com.study.designpattern.factory.IPay;

public class AliPayFactory implements IPayFactory {
    @Override
    public IPay create() {
        return new AliPay();
    }
}
