package com.example.leetcodejava.Algorithm.Sort;

/**
 *  快速排序
 *
 *  时间复杂度O(logn)
 */
public class QuickSort {

    public static void quickSort(int[] a, int startIndex, int endIndex) {
        // 递归结束条件: startIndex大于或等于endIndex
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(a, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(a, startIndex, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, endIndex);
    }

    /**
     * 分治（双边循环法）
     * 将数组的某一段元素进行划分，小的在左边，大的在右边
     */
    public static int partition(int[] a, int start, int end) {
        //每次都以最右边的元素作为基准值
        int base = a[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
        while (start < end) {
            while (start < end && a[start] <= base)
                //从左边开始遍历，如果比基准值小，就继续向右走
                start++;
            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
            if (start < end) {
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;

                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }
            while (start < end && a[end] >= base)
                //从右边开始遍历，如果比基准值大，就继续向左走
                end--;
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if (start < end) {
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;

                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }
        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    /**
     * 分治(单边循环法)
     */
    public static int partition2(int[] a, int start, int end) {

        // 取第1个位置(也可以选择随机位置)的元素作为基准元素
        int privot = a[start];

        // 设置一个mark指针指向数列起始位置，这个mark指针代表小于基准元素的区域边界
        int mark = start;

        // 从基准元素的下一个位置开始遍历数组
        for (int i = start + 1; i <= end; i++) {
            //如果遍历到的元素小于基准元素，则需要做两件事:第一，把mark指针 右移1位，因为小于pivot的区域边界增大了1;
            //第二，让最新遍历到的元素和mark指针所在位置的元素交换位置，因为最新遍历的元素归属于小于pivot的区域
            if (a[i] < privot) {
                mark++;
                int temp = a[mark];
                a[mark] = a[i];
                a[i] = temp;
            }
        }
        // 最后把pivoit基准元素交换到mark指针所在位置
        a[start] = a[mark];
        a[mark] = privot;
        return mark;
    }

    public static class BucketSort {

    }
}
