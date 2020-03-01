package com.study.designpattern.prototype;

public interface IPrototype {
    //利用jdk的object执行浅拷贝
    Object clone();
    //序列化深拷贝
    Object deepSerializableClone();
    //json深拷贝
    Object deepJsonClone();
}
