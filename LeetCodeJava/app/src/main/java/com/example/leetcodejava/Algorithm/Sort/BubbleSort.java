package com.example.leetcodejava.Algorithm.Sort;

/**
 *  冒泡排序 时间复杂度O(n^2)  总共遍历（元素数量-1)轮
 */
public class BubbleSort {
    /**
     * 冒泡排序第1版原始实现
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j+1]) {

                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    /** 冒泡排序第2版 优化
     * 在这种情况下，如果能判断出数列已经有序，并做出标记，那么剩下的几轮排序就不必执行了，可以提前结束工作。
     */
    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记 ，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;

                    // 因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }













    /**
     *  冒泡排序第3版 优化
     *  我们可以在每一轮排序后，记录下来最 后一次元素交换的位置，该位置即为无序数列的边界，再往后就是有序 区了。
     */
    public static void bubbleSort3(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;

        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;

                    //因为有元素进行交换，所以不是无序的，标记变为false
                    isSorted = false;

                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;

            if (isSorted) {
                break;
            }
        }
    }






}
