package com.askerlve.datastruct.queue;

/**
 * @author Askerlve
 * @Description: CircularDeque, 循环双端队列
 * @date 2019/4/29上午9:27
 */
public class CircularDeque {

    private int[] data;
    private int size;
    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public CircularDeque(int k) {
        this.data = new int[k];
        this.size = 0;
        this.head = 1;
        this.tail = -1;

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == data.length) {
            return false;
        }
        --head;
        if (head < 0) {
            head = data.length + head;
        }
        data[head % data.length] = value;
        if (size == 0) {
            tail = head;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == data.length) {
            return false;
        }
        data[++tail % data.length] = value;
        if (size == 0) {
            head = tail;
        }
        size++;
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head++;
        size--;
        return true;


    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail--;
        if (tail < 0) {
            tail = data.length + tail;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return data[head % data.length];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return data[tail % data.length];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;

    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == data.length;

    }

    public static void main(String[] args) {
        CircularDeque obj = new CircularDeque(50);
        boolean param_1 = obj.insertFront(10);
        boolean param_2 = obj.insertLast(20);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
    }

}
