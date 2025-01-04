package com.itcrazy.algorithm.sort;

/**
 * @author: dengxin.chen
 * @version: $ QuickSort.java,v0.1 2025-01-04 21:41 dengxin.chen Exp $
 * @description: 快排
 */
public class QuickSort {


    /**
     * 快速排序
     * by dengxin.chen
     *
     * @param arrays
     * @param left
     * @param right
     */
    public static void quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            int index = findPartitionIndex(arrays, left, right);
            quickSort(arrays, left, index - 1);
            quickSort(arrays, index + 1, right);
        }
    }

    /**
     * 找到分割位置
     * by dengxin.chen
     *
     * @param arrays
     * @param left
     * @param right
     * @return
     */
    public static int findPartitionIndex(int[] arrays, int left, int right) {
        int i = left;
        int j = right;
        int tmp = arrays[i];
        while (i < j) {
            while (arrays[j] >= tmp && i < j) {
                j--;
            }
            if (i < j) {
                arrays[i] = arrays[j];
                i++;
            }
            while (arrays[i] < tmp && i < j) {
                i++;
            }
            if (i < j) {
                arrays[j] = arrays[i];
                j--;
            }
        }
        arrays[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] arrys0 = {5, 9, 1, 7, 8};
        quickSort(arrys0, 0, arrys0.length - 1);
        for (int element : arrys0) {
            System.out.print(element + " ");
        }
    }
}
