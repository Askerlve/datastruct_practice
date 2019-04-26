package com.askerlve.datastruct.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Askerlve
 * @Description: 集合全排列
 * @date 2019/4/26上午9:27
 */
public class CollectionAllPermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        allrange(0, nums, list);
        return list;
    }

    public void allrange(int k, int[] nums, List<List<Integer>> list) {
        if (k == nums.length - 1) {
            List l = new LinkedList();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            list.add(l);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
            allrange(k + 1, nums, list);
            {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }

}
