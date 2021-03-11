package com.example.leetcodejava.Algorithm.Sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 算法步骤
 *
 * 1、首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2、再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3、重复第二步，直到所有元素均排序完毕。
 */

public class SelectionSort {

    public static void selectSort(int[] arr) {

        // 总共要经过N-1轮比较
        for (int i = 0; i < arr.length - 1; i++) {  // 做第i趟排序
            int min = i;

            for (int j = i + 1; j < arr.length; j++) { // 选最小的记录
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 在内层循环结束，找到了本轮循环的最小值，将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
