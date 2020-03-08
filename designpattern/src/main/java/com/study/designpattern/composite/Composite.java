package com.study.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 树干，可以下挂叶子节点，增加（add remove）
 */
public class Composite implements AbsComponent{
    private String name;
    private int level;

    private List<AbsComponent> nodes = new ArrayList<>();

    public Composite(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (AbsComponent node:nodes) {
            for (int i = 0; i < this.level; i++) {
                System.out.print("\t");
            }
            node.show();
        }
    }

    public void add(AbsComponent component) {
        nodes.add(component);
    }

    public void remove(int index) {
        nodes.remove(index);
    }
}
