package com.study.designpattern.expression;

import java.util.Stack;

public class Calculator {

    Stack<String> operStack = new Stack<>();
    Stack<IArithmeticInterpreter> dataStack = new Stack<>();

    public Calculator(String expression) {
        this.parse(expression);
    }



    private void parse(String expression) {
        String[] expressionArr = expression.split(" ");
        for (int i = 0; i < expressionArr.length; i++) {
            String exp = expressionArr[i];
            if (OperationUtils.isDigit(exp)) {
                dataStack.push(new NumInterpreter(Integer.valueOf(exp)));
            } else if (OperationUtils.isOperator(exp)) {
                //处理操作符
                if (operStack.isEmpty()) {
                    operStack.push(exp);
                } else {
                    //操作符优先级处理
                    OperationUtils.doMatch(dataStack, operStack, exp.charAt(0));
                }
            } else if("(".equals(exp) ) {
                operStack.push(exp);
            } else {
                // 处理右括号的情况
                OperationUtils.doMatch(dataStack, operStack);
            }
        }
        while (operStack.size() > 0) {
            String preOp = operStack.peek();
            if("(".equals(preOp) ){
                operStack.pop();
                continue;
            }
            OperationUtils.doMatch(dataStack, operStack);
        }

    }

    public int calculate(){
       return dataStack.pop().interpreter();
    }


}
