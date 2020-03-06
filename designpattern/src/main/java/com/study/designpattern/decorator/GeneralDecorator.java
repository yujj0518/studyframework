package com.study.designpattern.decorator;

import java.util.List;

/**
 * 普通用户装饰器
 */
public class GeneralDecorator extends BaseNavigationDecorator {
    public GeneralDecorator(Navigation navigation) {
        super(navigation);
    }

    @Override
    public List<String> getMenu() {
        List<String> menus = super.getMenu();
        menus.add("题库");
        return menus;
    }
}
