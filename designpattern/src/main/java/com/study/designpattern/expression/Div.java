package com.study.designpattern.expression;

public class Div extends Interpreter {
    public Div(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpreter() {
        return this.left.interpreter() / this.right.interpreter();
    }
}
