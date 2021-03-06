package com.askerlve.datastruct.str.str_match;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Askerlve
 * @Description: rk算法，BF算法的升级版,仅支持字母字符串
 * @date 2019/2/2上午11:47
 */
public class RabinKarp2 {

    private static final char[] RK_STR = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '
    };

    /** 字符串对照表 */
    private static final Map<Character, Integer> CHAR_MAP = new HashMap<>(RK_STR.length);

    static {
        for (int i = 0; i < RK_STR.length; i++) {
            CHAR_MAP.put(RK_STR[i], i + 1);
        }
    }

    /**
     * 进行字符串的查找函数
     *
     * @param src 源字符串
     * @param find 查找的字符串
     * @return 返回索引的下标位置
     */
    public int find(String src, String find) {

        if (null == src || null == find) {
            return -1;
        }

        char[] srcCharrs = src.toCharArray();
        char[] findChars = find.toCharArray();

        // 1,计算查找字符串的hash
        long findHash = countHash(findChars);

        int findIndex = 0;
        while (findIndex < srcCharrs.length) {
            // 如果超过了原始字符，则直接 返回
            if (findIndex + findChars.length > src.length()) {
                return -1;
            }

            int end = findIndex + findChars.length;

            long hash2 = countHash2(srcCharrs, findIndex, end);

            if (hash2 == findHash) {
                // 再检查字符串是否匹配
                if (match(findChars, srcCharrs, findIndex)) {
                    return findIndex;
                }
            }
            findIndex = findIndex + 1;
        }

        return -1;
    }

    /**
     * 进行字符串与源字符串的比较，检查是否相等
     *
     * @param countArrs
     * @param src
     * @param start
     * @return
     */
    private boolean match(char[] countArrs, char[] src, int start) {
        for (int i = 0; i < countArrs.length; i++) {
            if (countArrs[i] != src[i + start]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 计算hash值2的方法
     *
     * @param countArrs 原始字符串1
     * @param start 起始位置
     * @param end 结束位置
     * @return 查找到索引位置
     */
    private long countHash2(char[] countArrs, int start, int end) {
        long rsp = 0l;

        // 1,进行模式串的计算
        for (int i = end - 1; i >= start; i--) {
            rsp += CHAR_MAP.get(countArrs[i]);
        }

        return rsp;
    }

    /**
     * 计算hash值1的方法
     *
     * @param countArrs
     * @return
     */
    private long countHash(char[] countArrs) {
        long rsp = 0l;

        // 1,进行模式串的计算
        for (int i = countArrs.length - 1; i >= 0; i--) {
            rsp += CHAR_MAP.get(countArrs[i]);
        }

        return rsp;
    }

    public static void main(String[] args) {
        String pat = "sf";
        String txt = "fdsfdsfdsfds";

        int offset = new RabinKarp2().find(txt,pat);

        // print results
        System.out.println("text:    " + txt);

        // from brute force search method 1
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++)
            System.out.print(" ");
        System.out.println(pat);
    }

}
