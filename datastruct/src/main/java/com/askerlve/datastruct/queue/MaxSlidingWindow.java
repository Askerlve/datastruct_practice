package com.askerlve.datastruct.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Askerlve
 * @Description: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * @date 2019/4/29上午9:43
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        //创建双端队列（双向链表），实现最大窗口结构
        //先向队列放入k个数，之后再头去掉一个，尾加上一个计算最大值
        int[] res = new int[nums.length - k + 1];
        int indexRes = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        for (int i = 0; i < k; i++) {

            //向队列尾部加值，如果当前值比尾部第一个值大，尾部数弹出，直到队列尾部值大于当前值或队列为空，然后插入当前值下标进队列
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);
        }
        res[indexRes] = nums[maxQueue.peekFirst()];

        int L = 0;
        for (int i = k; i < nums.length; i++) {

            //队尾加入一个数，对头去掉一个数，调整这两个操作之后双端链表的状态
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);

            //如果过期下标（即对头淘汰的下标和对头的下标相同），就弹出对头，否则不做任何操作
            if (L == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            //左边索引变化，向结果数组里插值
            L++;
            indexRes++;
            res[indexRes] = nums[maxQueue.peekFirst()];
        }

        return res;
    }

    //20 ms
    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (k <= 0 || nums.length == 0) return new int[0];

        //滑动窗口的左、右指针
        int l = 0, r = 0, n = nums.length;
        int[] max = new int[n - k + 1];

        //双端队列，时间复杂度On
        Deque<Integer> dq = new ArrayDeque<>(k);

        while (r < n) {
            //删除旧的顶点数据
            if (r >= k && dq.peekFirst() <= r - k) {
                dq.removeFirst();
            }

            //当右指针元素大于列尾元素时，删除列尾元素
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);

            //右指针比左指针，快k-1个步
            if (r >= k - 1) {
                max[l++] = nums[dq.peekFirst()];
            }
            r++;
        }
        return max;
    }

    //4 ms
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length)
            return new int[]{};

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = k - 1;
        // 先求出第一个窗口的最大值
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        result[resultIndex++] = max;
        // 从第二个窗口开始
        while (++end < nums.length) {
            int oldMax = max;
            // 如果当前数字（当前窗口最右边的数）比之前窗口的最大值大，则当前窗口的最大值就是该数
            if (nums[end] > max) {
                max = nums[end];
            }
            int oldStart = start;
            start += 1;
            // 如果当前数没有比之前的窗口的最大值大，并且之前窗口的最大值就是窗口最左边的数，
            // 则之前的最大值被新的窗口丢弃，需要找出新的窗口的最大值
            if (oldMax == max && nums[oldStart] == max) {
                // 先把当前窗口最左边的数当成最大值，遍历该窗口，找出最大值
                max = nums[start];
                for (int i = start; i <= end; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
            }
            result[resultIndex++] = max;
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] arrs = {1, -1};
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(arrs, 1)));
    }

}
