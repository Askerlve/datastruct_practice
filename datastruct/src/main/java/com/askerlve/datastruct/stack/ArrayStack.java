package com.askerlve.datastruct.stack;

/**
 * @author Askerlve
 * @Description: ArrayStack
 * @date 2019/4/26上午8:42
 */
public class ArrayStack<T> {

    private T[] datas;
    private int dataSize;

    public ArrayStack(int capacity) {
        this.dataSize = 0;
        datas = (T[]) new Object[capacity];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return dataSize == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return datas[dataSize - 1];
    }

    public T pop() {
        T e = peek();
        if(dataSize > 0) {
            datas[dataSize - 1] = null;
            dataSize--;
        }
        return e;
    }

    public void push(T value) {

        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (dataSize == datas.length) {
            resize(2 * datas.length);
        }
        datas[dataSize ++] = value;
    }

    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < dataSize; i++) {
            newData[i] = datas[i];
        }
        datas = newData;
    }

    public void printAll() {
        for (int i = 0; i < dataSize; i++) {
            System.out.println(peek());
        }
    }

}
