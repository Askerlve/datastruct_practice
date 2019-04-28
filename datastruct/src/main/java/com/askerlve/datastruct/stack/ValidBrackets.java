package com.askerlve.datastruct.stack;

import java.util.Stack;

/**
 * @author Askerlve
 * @Description: 有效的括号,给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * @date 2019/4/28上午9:15
 */
public class ValidBrackets {

    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char alp : s.toCharArray()) {
            if (alp == '(') stack.push(')');
            else if (alp == '[') stack.push(']');
            else if (alp == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != alp) return false;
        }
        return stack.isEmpty();
    }

}
