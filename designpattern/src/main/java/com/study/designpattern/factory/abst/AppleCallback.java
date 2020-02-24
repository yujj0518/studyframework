package com.study.designpattern.factory.abst;

public class AppleCallback implements ICallback {
    @Override
    public void callback() {
        System.out.println("AppleCallback.callback");
    }
}
