package com.study.designpattern.decorator;

import java.util.List;

/**
 * vip装饰器
 */
public class VipDecorator extends BaseNavigationDecorator {
    public VipDecorator(Navigation navigation) {
        super(navigation);
    }

    @Override
    public List<String> getMenu() {
        List<String> menus = super.getMenu();
        menus.add("成长墙");
        menus.add("作业");
        return menus;
    }
}
