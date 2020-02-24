package com.study.designpattern.factory.abst;

public class AliCallback implements ICallback {
    @Override
    public void callback() {
        System.out.println("AliOrder.callback");
    }
}
