package com.askerlve.datastruct.array;

import java.util.Arrays;

/**
 * @author Askerlve
 * @Description: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素
 * @date 2019/4/24上午9:00
 */
public class ManyNum {

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length/2;
        return nums[n];
    }

    //摩尔投票法
    public int majorityElement2(int[] nums) {

        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else if (--count == 0) {
                major = nums[i + 1];
            }
        }

        return major;

    }

    public static void main(String[] args) {
        System.out.println(new ManyNum().majorityElement1(new int[]{1}));
    }

}
