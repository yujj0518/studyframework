package com.study.designpattern.expression;

public class Add extends Interpreter {
    public Add(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() + this.right.interpreter();
    }
}
