package com.example.leetcodejava.Algorithm.Sort;

import java.util.Arrays;

/**
 * 堆排序(通过二叉堆实现)
 *
 * 这里是构建最大堆，实现升序排序
 * （构建最小堆，实现降序排序）
 *
 * 可以归纳出堆排序算法的步骤。
 * 1. 把无序数组构建成二叉堆。需要从小到大排序，则构建成最大堆;需 要从大到小排序，则构建成最小堆。
 * 2. 循环删除堆顶元素，替换到二叉堆的末尾，调整堆产生新的堆顶。
 *
 *
 * 时间复杂度O（nlogn)
 * 空间复杂度O（1)
 */
public class HeapSort {

    /**
     * “下沉”调整
     * @param array 待调整的堆
     * @param parentIndex 要“下沉”的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点的值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            // 如果父节点大于任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex])
                break;

            //父节点小于子节点，需要交换
            // 无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序(升序)
     * @param array
     */
    public static void heapSort(int[] array) {
        // 1.把无序数组构建成最大堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }

        // 2.循环删除堆顶元素，移到元素尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0 ; i--) {
            // 最后一个元素和第1个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // “下沉”调整
            downAdjust(array, 0, i);
        }
    }

}
