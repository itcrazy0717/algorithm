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
    public static void quickSort1(int[] arrays, int left, int right) {
        if (left < right) {
            int index = findPartitionIndex(arrays, left, right);
            quickSort1(arrays, left, index - 1);
            quickSort1(arrays, index + 1, right);
        }
    }

    /**
     * 快速排序
     * by dengxin.chen
     *
     * @param arrays
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arrays, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tmp = arrays[left];
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
                arrays[i] = tmp;
                quickSort2(arrays, left, i - 1);
                quickSort2(arrays, i + 1, right);
            }
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
        int[] arrays1 = {6, 9, 1, 7, 2};
        int[] arrays2 = {10, 3, 1, 7, 2};
        quickSort1(arrays1, 0, arrays1.length - 1);
        quickSort2(arrays2, 0, arrays2.length - 1);
        for (int element : arrays1) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : arrays2) {
            System.out.print(element + " ");
        }
    }
}
