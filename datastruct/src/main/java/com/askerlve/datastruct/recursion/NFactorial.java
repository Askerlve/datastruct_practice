package com.askerlve.datastruct.recursion;

/**
 * @author Askerlve
 * @Description: n阶乘
 * @date 2019/4/26上午9:16
 */
public class NFactorial {

    public static int factorial(int n) {
        if(n<=1)
            return 1;
        else
            return n*factorial(n-1);
    }

}
