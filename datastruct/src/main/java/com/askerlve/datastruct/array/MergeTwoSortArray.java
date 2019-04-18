package com.askerlve.datastruct.array;

/**
 * @author Askerlve
 * @Description: 合并两个有序数组
 * @date 2019/4/18上午9:51
 */
public class MergeTwoSortArray {

    /**
     * @param nums1 有序数组a
     * @param m     有序数组a的长度
     * @param nums2 有序数组b
     * @param n     有序数组b的长度
     * @return
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            }else{
                nums1[k--] = nums1[i--];
            }
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 5, 6, 0};
        int[] b = new int[]{4};
        new MergeTwoSortArray().merge(a, 3, b, 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
