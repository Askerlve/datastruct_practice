package com.askerlve.datastruct.stack;

import java.util.Stack;

/**
 * @author Askerlve
 * @Description: 最长有效括号, 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 * @date 2019/4/28上午9:25
 */
public class LongValidBrackets {

    /**
     * 由左至右: 1.')'數量 > '('數量時，一定無效，數量歸零，繼續計算；
     *          2.若')'數量 = '('數量時，當前有效；
     *          3.若最後 ')'數量 < '('數量，表示無法確定有效括弧，只能確定<=')'數量。故需倒序再驗證一次。
     * 由右至左: 1.')'數量 < '('數量時，一定無效，數量歸零，繼續計算；
     *          2.若')'數量 = '('數量時，當前有效；
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

    public int longestValidParentheses2(String s) {
        int res = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i);
            if (a == '(') {
                stack.push(i);
            } else if (a == ')') {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if(stack.empty()){
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongValidBrackets().longestValidParentheses2("(()"));
    }

}
