package com.example.leetcodejava;

public class LeetCode16 {

    /**
     * 面试题 16.16. 部分排序
     * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，
     * 整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
     * 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
     *
     * 示例：
     * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
     * 输出： [3,9]
     *
     * 提示：
     * 0 <= len(array) <= 1000000
     */

    /**
     * 思路
     *
     * 题目数组都是单调递增的
     * 当一个数a[i]左侧有一个数比它大的时候，或者右侧有一个数比它小的时候，它一定是在被排序的序列内。
     * 因为一个数如果 左边的数都比它小，右边的数都比它大，显然没必要排序。
     * 关键是我们如何找出
     *
     * <1>最右侧一个a[i]，它的左边含有一个大于它的数
     * <2>最左侧一个a[i]，它的右边含有一个小于它的数
     * 我们这里可以使用两次遍历，分别从左往右找<1>，从右往左找<2>。
     *
     *  记录当前遍历序列的最大值MAX，如果有一个数比它小，那么记录这个数的index，遍历完成后，这个index即是<1>
     *  记录当前遍历序列的最小值MIN，如果有一个数比它大，那么记录这个数的index，遍历完成后，这个index即使<2>
     *
     */
    public int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int r = -1, l = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //正向遍历记录最右区间值
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }
        //反向遍历记录最左区间值
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }
        return new int[]{l, r};
    }
}
