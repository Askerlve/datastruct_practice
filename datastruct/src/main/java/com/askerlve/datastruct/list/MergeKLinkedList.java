package com.askerlve.datastruct.list;

import java.util.PriorityQueue;

/**
 * @author Askerlve
 * @Description: 合并K个排序链表
 * @date 2019/4/25上午9:22
 */
public class MergeKLinkedList {

    //堆排序实现
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)-> o1.val - o2.val);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        ListNode head = new ListNode(-1), cur = head;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;

            if (temp.next != null) {
                queue.add(temp.next);
            }
        }

        return head.next;

    }

    public ListNode mergeKListsByMergeSort(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        int low = 0, high = lists.length - 1;

        /**
         * lo < hi 而不是 lo <= hi
         * 以及mid = (hi + lo - 1) / 2 而不是mid = (hi + lo) / 2
         * 都避免了自己与自己归并 [0 mid]是i的活动范围 对于奇偶list长度都成立
         */
        while (low < high) {
            int mid = (high + low - 1) >> 1;
            for (int i = 0; i <= mid; i++) {
                lists[i] = merge2Lists(lists[i], lists[high - i]);
            }
            high = (low + high) >> 1;
        }

        return lists[0];

    }

    public ListNode merge2Lists(ListNode la, ListNode lb) {

        if (la == null) return lb;
        if (lb == null) return la;

        ListNode p = la;
        ListNode q = lb;
        ListNode head;

        if (p.val < q.val) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        ListNode r = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
