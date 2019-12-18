package com.askerlve.datastruct.str;

/**
 * @author Askerlve
 * @Description: 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *               1).'.' 匹配任意单个字符。
 *               2).'*' 匹配零个或多个前面的元素。
 *               3).匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * @date 2019/5/20上午9:23
 */
public class StrPattern {

    //深度搜索
    public boolean dfs(String s, String p) {
        //边界条件
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        //第二位不是*
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) return false;
            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                    && dfs(s.substring(1), p.substring(1));  //减小问题规模
        }

        //第二位是*
        while (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            if (dfs(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        // 前面没有匹配元素
        return dfs(s, p.substring(2));
    }

    //动态规划方法
    public boolean dp(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen + 1][pLen + 1];
        memory[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    memory[i][j] = memory[i][j - 2] ||
                            (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && memory[i - 1][j]);
                } else {
                    memory[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && memory[i - 1][j - 1];
                }
            }
        }
        return memory[sLen][pLen];
    }

}
