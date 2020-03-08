package com.study.designpattern.composite;

public class Test {
    public static void main(String[] args) {
        Composite root = new Composite("宇宙",1);

        Composite diqiu = new Composite("地球",2);
        Composite yazhou = new Composite("亚洲",3);
        Composite ouzhou = new Composite("欧洲",3);
        diqiu.add(ouzhou);
        diqiu.add(yazhou);
        Composite china = new Composite("中国",4);
        AbsComponent shanghai = new Leaf("上海",5);
        china.add(shanghai);
        Composite janpan = new Composite("日本",4);
        yazhou.add(china);
        yazhou.add(janpan);


        Composite fire = new Composite("火星",2);
        Composite mu = new Composite("木星",2);
        Composite glod = new Composite("金星",2);

        root.add(diqiu);
        root.add(fire);
        root.add(mu);
        root.add(glod);

        root.show();
    }
}
