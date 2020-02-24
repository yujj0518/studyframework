package com.study.designpattern.factory.abst;

public class ApplePayFactory implements IPayFactory {
    @Override
    public IRequest startRequest() {
        return new AppleRequest();
    }

    @Override
    public ICallback endCallback() {
        return new AppleCallback();
    }
}
