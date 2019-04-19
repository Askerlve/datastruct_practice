package com.askerlve.datastruct.list;

/**
 * @author Askerlve
 * @Description: CycleLinkedList，循环单链表
 * @date 2019/4/19上午8:55
 */
public class CycleLinkedList<T> {

    class Element<T> {
        public T value = null;
        private Element next = null;
    }

    private Element<T> header = null;//头结点


    public CycleLinkedList() {
        header = new Element();
        header.value = null;
        header.next = header;
    }

    /**
     * 插入链表
     *
     * @param o
     */
    void insertList(T o) {
        Element e = new Element();
        e.value = o;
        if (header.next == header)//第一次插入元素
        {
            header.next = e;
            e.next = header;
        } else//不是第一次插入元素
        {
            Element temp = header;
            while (temp.next != header)//寻找最后一个元素
            {
                temp = temp.next;
            }
            temp.next = e;
            e.next = header;//新插入的最后一个节点指向头结点
        }
    }

    /**
     * 删除链表中第i个元素
     *
     * @param o
     */
    void deletelist(T o) {
        Element temp = header;
        while (temp.next != header) {
            //判断temp当前指向的结点的下一个结点是否是要删除的结点
            if (temp.next.value.equals(o)) {
                temp.next = temp.next.next;//删除结点
            } else {
                temp = temp.next;//temp“指针”后移
            }
        }
    }

    /**
     * 获取链表的第i个位置的元素
     *
     * @param i
     * @return
     */
    Element getElement(int i) {
        if (i <= 0 || i > size()) {
            return null;
        } else {
            int count = 0;
            Element element = new Element();
            Element temp = header;
            while (temp.next != header) {
                count++;
                if (count == i) {
                    element.value = temp.next.value;
                }
                temp = temp.next;
            }
            return element;
        }
    }

    /**
     * 链表长度
     *
     * @return
     */
    int size() {
        Element temp = header;
        int size = 0;
        while (temp.next != header) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 判断链表中是否存在某元素
     *
     * @param o
     * @return
     */
    Boolean isContain(Object o) {
        Element temp = header;
        while (temp.next != header) {
            if (temp.next.value.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 打印链表
     */
    void print() {
        System.out.print("打印链表：");
        Element temp = header;
        while (temp.next != header) {
            temp = temp.next;
            System.out.print(temp.value + "\t");
        }
        System.out.println();
    }

}
