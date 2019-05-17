package com.askerlve.datastruct.dynamic_program;

/**
 * @author Askerlve
 * @Description: 使用动态规划解决的思想来解决0-1背包的问题,每个物品的重量不同，价值也不相同，在重量不超过背包重量的前提下，让背包的总价值最大化.
 * @date 2019/5/17上午9:24
 */
public class ZeroOnePackage {

    /**
     * @param weight 物品重量
     * @param value  物品价值
     * @param n      物品个数
     * @param w      背包承受的最大重量
     * @return
     */
    public int f2(int[] weight, int[] value, int n, int w) {

        int[][] states = new int[n][w + 1];

        for (int i = 0; i < n; ++i) { // 初始化 states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        states[0][weight[0]] = value[0];

        for (int i = 1; i < n; ++i) { // 动态规划，状态转移

            for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }

            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第 i 个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    //考虑到重量一致情况下，比较价值是否一致，若大，则替换原有重量下的价值最大
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }

        }

        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }

        return maxvalue;

    }

}
