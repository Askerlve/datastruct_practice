package com.askerlve.datastruct.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Askerlve
 * @Description: 单链表常用操作。
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * @date 2019/4/22上午9:01
 */
public class LinkedListCommonOperations {

    // 单链表反转
    public static Node reverse(Node list) {

        Node headNode = null;
        Node previousNode = null;
        Node currentNode = list;

        while (currentNode != null) {

            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }

            //位置互换，将下一个指向上一个
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;

        }

        return headNode;
    }

    //快慢指针检测环　　　　　　　　　　　　　　　　　　　　　 　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　  检测环
    public static boolean checkCircle(Node head) {

        if (head == null) return false;

        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    //哈希表
    public static boolean hasCycle(Node head) {
        Set<Node> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {

        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head;

        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node r = head;
        while (p != null && q != null) {
            if (p.data < q.data) {
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

    // 删除倒数第K个结点，一样使用快慢指针，两个指针之间相差为k
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node lastNode = new Node(0, null);
        Node forthNode = new Node(1, lastNode);
        Node thirdNode = new Node(2, forthNode);
        Node secondNode = new Node(3, thirdNode);
        Node fristNode = new Node(4, secondNode);
        printAll(fristNode);
        Node middleNode = reverse(fristNode);
        printAll(middleNode);
    }

}
