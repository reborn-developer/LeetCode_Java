package com.example.leetcodejava;

import java.util.ArrayList;
import java.util.List;

public class LeetCode969 {
    /**
     *  LeetCode969.煎饼排序
     *  给定数组A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，
     *  然后反转A的前k个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组A的排序。
     *  返回能使A排序的煎饼翻转操作所对应的k值序列。!!!!!!
     *  任何将数组排序且翻转次数在10 * A.length范围内的有效答案都将被判断为正确。
     *
     *  示例 1：
     *  输入：[3,2,4,1]
     *  输出：[4,2,4,3]
     *  解释：
     *  我们执行4次煎饼翻转，k 值分别为 4，2，4，和 3。
     *  初始状态 A = [3, 2, 4, 1]
     *  第一次翻转后 (k=4): A = [1, 4, 2, 3]
     *  第二次翻转后 (k=2): A = [4, 1, 2, 3]
     *  第三次翻转后 (k=4): A = [3, 2, 1, 4]
     *  第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
     *
     *  示例 2：
     *  输入：[1,2,3]
     *  输出：[]
     *  解释：
     *  输入已经排序，因此不需要翻转任何内容。
     *  请注意，其他可能的答案，如[3，3]，也将被接受。
     *
     *  提示：
     *  1、1 <= A.length <= 100
     *  2、A[i] 是 [1, 2, ..., A.length] 的排列
     */

    /**
     * 先将第i大的值倒转到第一位，然后倒转前i个数，那么第一位的值就会到第i位，完成了归位。
     * 即先找到最大的值倒转到第一位，然后倒转前i个数，那么最大值就会跑到最后一位，完成归位。
     * 然后找到第2大的值继续以上操作
     * 第3大 ...
     */

    /**
     *      i = 3   max = 2    list[3, 4, ]    A[4,2,3,1]  A[1,3,2,4]
     *      i = 2   max = 1    list[3,4,2, 3]  A[3,1,2,4]  A[2,1,3,4]
     *      i = 1   max = 0    list[3,4,2,3,2]  A[1,2,3,4] continue
     *      i = 0   max = 0
     *
     *      验证 k[3,4,2,3,2]
     *      A[4,2,3,1] A[1,3,2,4] A[3,1,2,4] A[2,1,3,4] A[1,2,3,4] 正确
     */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = A.length-1; i >= 0 ; i--) { //从A.length-1开始，每次循环，都会将前i个数的最大值倒转到第i位。
            int maxIndex = find(A, i); //获得前i个数中的最大值的下标
            if (maxIndex != i){ //如果前i个数的最大值，并不在第i位，说明需要倒转顺序来进行调整
                if (maxIndex == 0){ //但如果最大值下标已经是第一了，直接倒转
                    list.add(i+1); //添加倒转顺序, 注意i代表下标，所以对应前k个元素，应该+1
                    reverse(A,i);
                    continue;
                }
                list.add(maxIndex+1); //注意i、maxIndex代表下标，所以对应前k个元素，应该+1
                list.add(i+1);
                reverse(A,maxIndex);//倒转数组(把最大值倒转到第一位)
                reverse(A,i); //倒转前i个(最终最大值倒转到最后一位)
            }
        }
        return list;
    }

    //寻找到最大值的下标
    public static int find(int[] nums,int end){ // end代表下标
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
    //反转数组
    public static void reverse(int[] A,int n){// n代表下标
        int[] nums = new int[A.length];
        for (int i = n; i >= 0; i--) {
            nums[n-i] = A[i];
        }
        for (int i = 0; i <= n; i++) {
            A[i] = nums[i];
        }
    }
}
