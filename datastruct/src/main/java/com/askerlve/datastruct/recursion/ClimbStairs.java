package com.askerlve.datastruct.recursion;

/**
 * @author Askerlve
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @date 2019/4/30上午9:19
 */
public class ClimbStairs {

    /**
     * climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        return climb_Stairs1(0, n);
    }
    public int climb_Stairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs1(i + 1, n) + climb_Stairs1(i + 2, n);
    }

    /**
     * 记忆化递归,加入缓存
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs2(0, n, memo);
    }
    public int climb_Stairs2(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs2(i + 1, n, memo) + climb_Stairs2(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 动态规划,不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * 第 ii 阶可以由以下两种方法得到：在第 (i-1)(i−1) 阶后向上爬一阶。在第 (i-2)(i−2) 阶后向上爬 22 阶。
     * 所以到达第 ii 阶的方法总数就是到第 (i-1)(i−1) 阶和第 (i-2)(i−2) 阶的方法数之和。令 dp[i]dp[i] 表示能到达第 ii 阶的方法总数：dp[i]=dp[i-1]+dp[i-2] dp[i]=dp[i−1]+dp[i−2]
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2]。可以很容易通过分析得出 dp[i]dp[i] 其实就是第 ii 个斐波那契数。
     * Fib(n)=Fib(n-1)+Fib(n-2) Fib(n)=Fib(n−1)+Fib(n−2)现在我们必须找出以 11 和 22 作为第一项和第二项的斐波那契数列中的第 nn 个数，也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
