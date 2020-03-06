package com.study.designpattern.decorator;

import java.util.ArrayList;
import java.util.List;

public class NavigationInfo implements Navigation {
    private List<String> menus;

    public NavigationInfo() {
        menus = new ArrayList<>();
    }

    @Override
    public List<String> getMenu() {
        return this.menus;
    }
}
