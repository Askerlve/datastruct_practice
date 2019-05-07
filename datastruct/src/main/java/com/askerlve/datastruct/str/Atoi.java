package com.askerlve.datastruct.str;

/**
 * @author Askerlve
 * @Description: 字符串转换整数 (atoi)
 * @date 2019/5/7上午9:39
 */
public class Atoi {

    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0){
            return 0;
        }

        str = str.trim();
        int last = 0;

        char c = str.charAt(0);

        if (c != '-' && c != '+' && (c < 48 || c > 57 )){
            //无效转换
            return 0;
        }
        int a = 0;
        if (c == '-' || c == '+'){
            a = 1;
        }

        for (int i = a; i < str.length(); i++) {
            char c1 = str.charAt(i);

            if (c1 >= 48 && c1 <= 57){
                if (c1 == '0' && last == 0){
                    continue;
                }
                int pop = c1 - 48;
                if (c == '+' || a == 0){
                    if (last > Integer.MAX_VALUE/10 || (last == Integer.MAX_VALUE/10 && pop > 7)){
                        return Integer.MAX_VALUE;
                    }
                }else {
                    if (-last < Integer.MIN_VALUE/10 || (-last == Integer.MIN_VALUE/10 && pop > 8)){
                        return Integer.MIN_VALUE;
                    }
                }

                last = pop + last * 10;
            }else {
                break;
            }
        }
        if (c == '-'){
            return -last;
        }

        return last;
    }

}
