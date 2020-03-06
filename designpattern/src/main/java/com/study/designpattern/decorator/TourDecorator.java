package com.study.designpattern.decorator;

import java.util.List;

/**
 * 游客装饰器
 */
public class TourDecorator extends BaseNavigationDecorator {

    public TourDecorator(Navigation navigation) {
        super(navigation);
    }

    @Override
    public List<String> getMenu() {
        List<String> menus = super.getMenu();
        menus.add("问答");
        menus.add("文章");
        menus.add("精品课");
        menus.add("冒泡");
        menus.add("商城");
        return menus;
    }
}
