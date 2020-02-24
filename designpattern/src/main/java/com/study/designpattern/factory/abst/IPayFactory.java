package com.study.designpattern.factory.abst;

public interface IPayFactory {
    IRequest startRequest();
    ICallback endCallback();
}
