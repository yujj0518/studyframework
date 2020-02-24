package com.study.designpattern.factory.abst;

public class AliRequest implements IRequest {
    @Override
    public void request() {
        System.out.println("AliRequest.request");
    }
}
