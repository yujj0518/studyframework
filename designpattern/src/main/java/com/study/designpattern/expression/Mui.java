package com.study.designpattern.expression;

public class Mui extends Interpreter {
    public Mui(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() * this.right.interpreter();
    }
}
