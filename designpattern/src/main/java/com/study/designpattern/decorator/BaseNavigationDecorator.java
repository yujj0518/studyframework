package com.study.designpattern.decorator;

import java.util.List;

/**
 * 抽象的装饰器
 */
public class BaseNavigationDecorator implements Navigation{
    private Navigation navigation;

    public BaseNavigationDecorator(Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    public List<String> getMenu() {
        return this.navigation.getMenu();
    }
}
