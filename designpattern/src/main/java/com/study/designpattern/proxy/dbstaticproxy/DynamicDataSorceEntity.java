package com.study.designpattern.proxy.dbstaticproxy;

public class DynamicDataSorceEntity {

    private static final String DEFAULT = null;

    private static ThreadLocal<String> local = new ThreadLocal();

    private DynamicDataSorceEntity() {
    }

    public static String get() {
        return local.get();
    }

    public static void restore() {
        local.set(DEFAULT);
    }

    public static void set(String source) {
        local.set(source);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }
}
