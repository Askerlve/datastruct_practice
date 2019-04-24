package com.askerlve.datastruct.array;

import java.util.Arrays;

/**
 * @author Askerlve
 * @Description: 给定一个未排序的整数数组，找出其中没有出现的最小的正整数
 * @date 2019/4/24上午9:32
 */
public class FindArrayMissIntNum {

    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        if(len == 0) return 1;
        Arrays.sort(nums);
        int max = nums[len -1];
        //如果最大的数是负数 返回1
        if(max <= 0) return 1;
        if(max > len) max = len;
        //基于桶排序方法，构建index和值相同的数组
        int[] bucket = new int[max + 1];
        for(int i = 0; i < len; i++){
            if(nums[i] <= 0 || nums[i] > len) continue;
            bucket[nums[i]]++;
        }
        //排除数组中全为大于len的值和数组中没有1的情况
        if(bucket.length == 0 || bucket[1] == 0) return 1;
        int i = 1;
        //当第一个index 不等于其值的下一个index为最终结果
        for(; i < bucket.length; i++){
            if(bucket[i] == 0) break;
        }
        return i ;

    }

    public int firstMissingPositive2(int[] nums) {

        //为什么+2?因为最小正整数为1
        int[] res=new int[nums.length+2];

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<=0)
                continue;
            if(nums[i]>nums.length)
                continue;
            res[nums[i]]=1;
        }

        for(int i=1;i<res.length;i++)
            if(res[i]==0) return i;

        return -1;

    }

}
