package com.example.leetcodejava.Algorithm.Sort;

/**
 *  计数排序
 */
public class CountSort {
    public static int[] countSort(int[] array) {
        //1、得到数列的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[max+1];

        // 3、遍历数组，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        // 4、遍历统计数组，输出结果

        int index = 0;
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }
    /**
     * 这段代码在开头有一个步骤，就是求数列的最大整数值max。后面创建 的统计数组countArray，长度是max+1，以此来保证数组的最后一个下标是max。
     */
}
