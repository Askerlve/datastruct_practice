package com.askerlve.datastruct.sort;

/**
 * @author Askerlve
 * @Description: 求一个数字的平方根
 * @date 2019/5/5上午9:20
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int r = x > 46340 ? 46340 : x;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int res = mid * mid;
            if (res < x) {
                l = mid + 1;
            } else if (res > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l - 1;
    }

}
