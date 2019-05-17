package com.askerlve.datastruct.map_reduce;

/**
 * @author Askerlve
 * @Description: 给定一个数组，使用分治算法来统计逆序对
 *               PS:我们期望数据从小到大排列，那完全有序的数据的有序度就是n(n-1)/2，逆序度等于 0；相反，倒序排列的数据的有序度就是 0，逆序度是 n(n-1)/2
 *               如:2,4,3,1,5,6;逆序对个数4:（2，1),(4,3),(4,1),(3,1)
 * @date 2019/3/14上午9:38
 */
public class CountSourWord {

    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p+r)/2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q+1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q+1, k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q-i+1); // 统计 p-q 之间，比 a[j] 大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) { // 处理剩下的
            tmp[k++] = a[i++];
        }
        while (j <= r) { // 处理剩下的
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r-p; ++i) { // 从 tmp 拷贝回 a
            a[p+i] = tmp[i];
        }
    }


}
