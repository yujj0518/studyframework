package com.study.designpattern.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrototypeShallowTest {

    public static void main(String[] args) {
        PrototypeA prototypeA = new PrototypeA();
        prototypeA.setId(100L);
        prototypeA.setName("小明");
        List<String> hobbes = new ArrayList<>();
        hobbes.add("看书");
        hobbes.add("游泳");
        prototypeA.setHobbes(hobbes);

        Map<String,String> map = new HashMap<>();
        map.put("1","aaa");
        map.put("2","bbb");
        prototypeA.setMap(map);

        PrototypeA copy = (PrototypeA) prototypeA.deepJsonClone();
        copy.getHobbes().add("篮球");
        copy.getMap().put("3","ccc");
        System.out.println("原来的id = [" + (prototypeA.getId()) + "]");
        System.out.println("原来的name = [" + (prototypeA.getName()) + "]");
        System.out.println("原来的hobbes = [" + (prototypeA.getHobbes()) + "]");
        System.out.println("原来的map = [" + (prototypeA.getMap()) + "]");



        System.out.println("复制的id = [" + (copy.getId()) + "]");
        System.out.println("复制的name = [" + (copy.getName()) + "]");
        System.out.println("复制的hobbes = [" + (copy.getHobbes()) + "]");
        System.out.println("复制的map = [" + (copy.getMap()) + "]");

        System.out.println("对象地址对比 = [" + (prototypeA == copy) + "]");
        System.out.println("爱好地址 = [" + (prototypeA.getHobbes() == copy.getHobbes()) + "]");
        System.out.println("id地址对比 = [" + (prototypeA.getId() == copy.getId()) + "]");
        System.out.println("name地址对比 = [" + (prototypeA.getName() == copy.getName()) + "]");
        System.out.println("name地址对比 = [" + (prototypeA.getMap() == copy.getMap()) + "]");
    }
}
