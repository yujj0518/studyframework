package com.study.designpattern.factory.method;

import com.study.designpattern.factory.AliPay;
import com.study.designpattern.factory.IPay;
import com.study.designpattern.factory.WechatPay;

public class WechatPayFactory implements IPayFactory {
    @Override
    public IPay create() {
        return new WechatPay();
    }
}
