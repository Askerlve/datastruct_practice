package com.askerlve.datastruct.str;

/**
 * @author Askerlve
 * @Description: 给定一个字符串，逐个翻转字符串中的每个单词
 *               无空格字符构成一个单词。
 *               输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *               如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 * @date 2019/5/5上午9:50
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i == -1) break;

            int j = s.lastIndexOf(' ', i);
            builder.append(s.substring(j + 1, i + 1) + " ");
            i = j - 1;
        }

        if (builder.length() > 0) builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("a  b     c".split(" ").length);
    }

}
