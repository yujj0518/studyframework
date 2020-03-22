package com.study.designpattern.expression;

import java.util.Stack;

public class OperationUtils {
    //操作符优先级定义
    private final static String OPERATOR_PRIORITY[] = new String[]{"+-", "*/", "^"};
    /**
     * 匹配括号
     *
     * @param dataStack 操作数栈
     * @param operStack 操作符栈
     */
    public static void doMatch(Stack<IArithmeticInterpreter> dataStack, Stack<String> operStack ){
        if(operStack.isEmpty()){
            return;
        }

        IArithmeticInterpreter right = dataStack.pop();
        IArithmeticInterpreter left = dataStack.pop();
        String opt = operStack.pop();
        String bracket = ")";
        if( !operStack.isEmpty() && operStack.peek().equals(")") ){
            operStack.pop();
        }
        operation(dataStack, right, left, opt);
    }

    private static void operation(Stack<IArithmeticInterpreter> dataStack, IArithmeticInterpreter right, IArithmeticInterpreter left, String opt) {
        if ("+".equals(opt)) {
            dataStack.push(new Add(left,right));
        } else if ("-".equals(opt)) {
            dataStack.push(new Sub(left,right));
        } else if ("*".equals(opt)) {
            dataStack.push(new Mui(left,right));
        } else if ("/".equals(opt)) {
            dataStack.push(new Div(left,right));
        }
    }

    /**
     * 匹配括号，处理优先级
     *
     * @param dataStack 操作数栈
     * @param operStack 操作符栈
     * @param curOper 当前操作符
     */
    public static void doMatch(Stack<IArithmeticInterpreter> dataStack, Stack<String> operStack, char curOper ){
        if( operStack.isEmpty() ){
            operStack.push( String.valueOf(curOper) );
            return;
        }

        String preOp = operStack.peek();
        if ( preOp.equals("(") ) {
            operStack.pop();
            operStack.push( String.valueOf(curOper) );
            return;
        }

        if (getPriority(preOp.charAt(0)) >= getPriority(curOper)) {
            IArithmeticInterpreter right = dataStack.pop();
            IArithmeticInterpreter left = dataStack.pop();
            String opt = operStack.pop();
            if (!operStack.isEmpty() && operStack.peek().equals(")") ) {
                operStack.pop();
            }
            operation(dataStack, right, left, opt);
            doMatch(dataStack, operStack, curOper);
        }else{
            operStack.push(String.valueOf(curOper));
        }
    }

    /**
     * 是否数字
     *
     * @param ch 数字参数
     * @return
     */
    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 是否操作符
     *
     * @param op 操作符
     * @return
     */
    public static boolean isOperator(char op){
        for(String ops : OPERATOR_PRIORITY ){
            if( ops.indexOf(op) != -1 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取操作符优先级
     *
     * @param op 操作符
     * @return
     */
    public static int getPriority(char op){
        for(int i = 0; i < OPERATOR_PRIORITY.length; ++i ){
            if( OPERATOR_PRIORITY[i].indexOf(op) != -1 ){
                return i;
            }
        }
        throw new RuntimeException( new Exception("don't support operator: " + op) );
    }
}
