package com.askerlve.zhaohang;

import java.util.Scanner;

/**
 * @author Askerlve
 * @Description: 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * @date 2019/12/18上午10:59
 */
public class XGame {

    public static int goodNumberCount(int max) {
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (isGoodNum(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isGoodNum(int x) {
        boolean flag = false;
        while (x != 0) {
            int t = x % 10;
            if (t == 3 || t == 4 || t == 7) {
                return false;
            } else if (t == 2 || t == 5 || t == 6 || t == 9) {
                flag = true;
            }
            x = x / 10;
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(goodNumberCount(n));
    }
}
