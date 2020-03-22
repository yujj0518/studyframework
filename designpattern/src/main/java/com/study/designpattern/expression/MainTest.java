package com.study.designpattern.expression;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("result = [" + new Calculator("10 * 30 + ( 20 - 30 + 88 )").calculate() + "]");
        System.out.println("result = [" + new Calculator("10000 + 30000 - ( 20 * ( 12 + 88 ) )").calculate() + "]");
    }
}
