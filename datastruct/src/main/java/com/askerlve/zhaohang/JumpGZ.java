package com.askerlve.zhaohang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Askerlve
 * @Description: 假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完n 个格子你才能抵达终点。每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
 * @date 2019/12/18上午11:54
 */
public abstract class JumpGZ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Jump(n));
    }

    public static int Jump(int conclusion) {
        if (conclusion == 0) return 0;
        else if (conclusion == 1) return 1;
        else if (conclusion == 2) return 2;
        else return Jump(conclusion - 1) + Jump(conclusion - 2);
    }

    public static List<Integer> getOneNumber(List<Integer> numbers) {
        List<Integer> results = new ArrayList<>();
        for (Integer i : numbers) {
            if (results.contains(i)) {
                continue;
            }
            results.remove(i);
        }
        return results;
    }

}
