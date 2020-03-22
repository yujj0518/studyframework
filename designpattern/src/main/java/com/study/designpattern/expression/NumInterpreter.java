package com.study.designpattern.expression;

public class NumInterpreter implements IArithmeticInterpreter{
    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpreter() {
        return this.value;
    }
}
