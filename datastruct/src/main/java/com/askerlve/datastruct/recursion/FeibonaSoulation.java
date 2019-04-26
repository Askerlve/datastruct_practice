package com.askerlve.datastruct.recursion;

/**
 * @author Askerlve
 * @Description: 斐波那契数列求值
 * @date 2019/4/26上午9:15
 */
public class FeibonaSoulation {

    public static long recursion(long n) {
        long result = 0;
        if (n <= 0)
            result = 0;
        if (n == 1 || n == 2)
            result = 1;
        if (n > 2) {
            result = recursion(n - 1) + recursion(n - 2);
        }
        return result;
    }

}
