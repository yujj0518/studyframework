package com.study.designpattern.factory.abst;

public class AppleRequest implements IRequest {
    @Override
    public void request() {
        System.out.println("AppleRequest.request");
    }
}
