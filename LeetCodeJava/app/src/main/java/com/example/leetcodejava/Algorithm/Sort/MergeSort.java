package com.example.leetcodejava.Algorithm.Sort;

/**
 * 归并排序
 *
 * 　归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的
 *  分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后
 *  递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 */
public class MergeSort {

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length]; // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static void mergeSort(int[] arr, int left, int right, int []temp) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(arr, left, mid, temp);          // 左边归并排序，使得左子序列有序
            mergeSort(arr, mid+1, right, temp);  // 右边归并排序，使得右子序列有序
            merge(arr,left, mid, right, temp);         // 将两个有序子数组合并操作
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左序列指针
        int j = mid + 1; //右序列指针
        int t = 0; // 临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];

            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) { // 将左序列剩余元素填充进temp中
            temp[t++] = arr[i++];
        }

        while (j <= right) { // 将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }

        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
