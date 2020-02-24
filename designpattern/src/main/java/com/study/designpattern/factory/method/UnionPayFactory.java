package com.study.designpattern.factory.method;

import com.study.designpattern.factory.IPay;
import com.study.designpattern.factory.UnionPay;

public class UnionPayFactory implements IPayFactory {

    @Override
    public IPay create() {
        return new UnionPay();
    }
}