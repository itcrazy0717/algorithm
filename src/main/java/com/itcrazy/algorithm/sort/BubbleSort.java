package com.itcrazy.algorithm.sort;

/**
 * @author: dengxin.chen
 * @version: $ BubbleSort.java,v0.1 2025-01-04 19:40 dengxin.chen Exp $
 * @description: 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序，从小到大
     * by dengxin.chen
     *
     * @param arrys
     */
    public static void bubbleSort0(int[] arrys) {
        for (int i = 0; i < arrys.length; i++) {
            for (int j = 1; j < arrys.length - i; j++) {
                // 从小到大排序
                if (arrys[j - 1] > arrys[j]) {
                    swap(arrys, j - 1, j);
                }
            }
        }
    }

    /**
     * 冒泡排序优化，如果数据已存在顺序，则终止比较
     * by dengxin.chen
     *
     * @param arrys
     */
    public static void bubbleSort1(int[] arrys) {
        int len = arrys.length;
        boolean switchEle = true;
        while (switchEle) {
            switchEle = false;
            for (int i = 1; i < len; i++) {
                if (arrys[i - 1] > arrys[i]) {
                    switchEle = true;
                    swap(arrys, i - 1, i);
                }
            }
            len--;
        }
    }

    /**
     * 继续优化，如果100个数，前10个已经排好序，后面90个就不需要进行排序了
     * by dengxin.chen
     *
     * @param arrys
     */
    public static void bubbleSort2(int[] arrys) {
        int len;
        int switchFlag = arrys.length;
        while (switchFlag > 0) {
            len = switchFlag;
            switchFlag = 0;
            for (int i = 1; i < len; i++) {
                if (arrys[i - 1] > arrys[i]) {
                    swap(arrys, i - 1, i);
                    switchFlag = i;
                }
            }
        }
    }

    /**
     * 交换两个数据的位置
     * by dengxin.chen
     *
     * @param arrays
     * @param left
     * @param right
     */
    public static void swap(int[] arrays, int left, int right) {
        int tmp = arrays[left];
        arrays[left] = arrays[right];
        arrays[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arrys0 = {5, 4, 1, 7, 8};
        int[] arrys1 = {5, 4, 1, 7, 8};
        int[] arrys2 = {5, 4, 1, 7, 8};
        bubbleSort0(arrys0);
        bubbleSort1(arrys1);
        bubbleSort2(arrys2);
        for (int element : arrys0) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : arrys1) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : arrys2) {
            System.out.print(element + " ");
        }
    }
}
