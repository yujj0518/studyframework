package com.study.designpattern.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        //声明菜单
        Navigation navigation = new NavigationInfo();
        System.out.println("初始化导航栏：---------" + navigation.getMenu() + "");

        Navigation tourDecorator = new TourDecorator(navigation);
        System.out.println("游客的导航栏：---------" + tourDecorator.getMenu() + "");

        Navigation generalDecorator = new GeneralDecorator(navigation);
        System.out.println("普通用户的导航栏：---------" + generalDecorator.getMenu() + "");

        Navigation vipDecorator = new VipDecorator(navigation);
        System.out.println("VIP学员的导航栏：---------" + vipDecorator.getMenu() + "");

    }
}
