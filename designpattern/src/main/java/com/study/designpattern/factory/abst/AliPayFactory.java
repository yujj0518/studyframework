package com.study.designpattern.factory.abst;

public class AliPayFactory implements IPayFactory {
    @Override
    public IRequest startRequest() {
        return new AliRequest();
    }

    @Override
    public ICallback endCallback() {
        return new AliCallback();
    }
}
