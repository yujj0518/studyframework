package com.study.designpattern.composite;

/**
 * 叶子节点,只能显示名称  不能操作
 */
public class Leaf implements AbsComponent {
    private String name;
    private int level;


    public Leaf(String name, int level) {
        this.level = level;
        this.name = name;
    }

    @Override
    public void show() {
        for (int i = 0; i < this.level; i++) {
            System.out.print("\t");
        }
        System.out.println(this.name);
    }
}
