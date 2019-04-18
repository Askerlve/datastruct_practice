package com.askerlve.datastruct.array;

/**
 * @author Askerlve
 * @Description: 有序数组
 * @date 2019/4/18上午9:18
 */
public class SortArray {

    private long[] array;
    private int nElems;

    //初始化
    public SortArray(int max) {
        array = new long[max];
        nElems = 0;
    }

    //返回数组中的大小
    public int size() {
        return nElems;
    }

    //查找的方法的实现
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        //二分查找
        while (lowerBound <= lowerBound) {
            //避免low和high比较大超过int最大值益处
            curIn = lowerBound + ((upperBound - lowerBound) >> 1);
            if (array[curIn] == searchKey) {
                return curIn;
            } else if (array[curIn] < searchKey) {
                lowerBound = curIn + 1;
            } else {
                lowerBound = curIn - 1;
            }
        }
        return -1;
    }

    //插入方法的实现
    public void insert(long value) {
        int j = 0;
        for (; j < nElems; j++) {
            if (array[j] > value) {
                break;
            }
        }
        //移动元素找到要插入的位置
        for (int k = nElems; k > j; k--) {
            array[k] = array[k - 1];
        }
        array[j] = value;
        nElems++;


    }

    //删除一个元素的实现
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                array[k] = array[k + 1];
            }
            nElems--;
            return true;
        }
    }

    //打印有序数组中的元素的值
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
