package com.study.designpattern.expression;

public class Sub extends Interpreter {
    public Sub(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() - this.right.interpreter();
    }
}
