package com.study.designpattern.factory.method;

import com.study.designpattern.factory.ApplePay;
import com.study.designpattern.factory.IPay;
import com.study.designpattern.factory.WechatPay;

public class ApplePayFactory implements IPayFactory {
    @Override
    public IPay create() {
        return new ApplePay();
    }
}
