package com.askerlve.datastruct.stack;

import java.util.Stack;

/**
 * @author Askerlve
 * @Description: 逆波兰表达式求值,有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * @date 2019/4/28上午10:03
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(- stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

}
