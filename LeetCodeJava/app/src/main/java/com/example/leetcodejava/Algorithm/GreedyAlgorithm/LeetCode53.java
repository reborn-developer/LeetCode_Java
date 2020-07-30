package com.example.leetcodejava.Algorithm.GreedyAlgorithm;

public class LeetCode53 {
    /**
     * LeetCode53.最大子序和  Easy
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     */

    /**
     *  方法一、贪心算法
     *  如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     *  如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
    /**
     * 复杂度分析
     * 时间复杂度:O(n)
     * 空间复杂度:o(1)
     */

    /**
     * 方法二、分治法
     * 分治法是将整个数组切分成几个小组，然后每个小组再切分成几个更小的小组，一直到不能继续切分也就是只剩一个数字为止。
     * 每个小组会计算出最优值，汇报给上一级的小组，一级一级汇报，上级拿到下级的汇报找到最大值，得到最终的结果。
     * 和归并排序的算法类似，先切分，再合并结果。
     *
     * 特别说明：
     *
     * 考虑第 3 部分跨越两个区间的连续子数组的时候，由于 nums[mid] 与 nums[mid + 1] 一定会被选取，以上的三个组合内的序列
     * 没有任何的重复的部分，而且一起构成所有子序列的全集，计算出这个三个子集合的最大值，然后取其中的最大值，就是这个问题的答案了。
     *
     * 然而前两个子组合可以用递归来解决，一个函数就搞定，第三个跨中心的组合应该怎么计算最大值呢？
     * 1、答案就是先计算左边序列里面的包含最右边元素的子序列的最大值，也就是从左边序列的最右边元素向左一个一个累加起来，
     * 找出累加过程中每次累加的最大值，就是左边序列的最大值。
     * 2、同理找出右边序列的最大值，就得到了右边子序列的最大值。
     * 3、左右两边的最大值相加，就是包含这两个元素的子序列的最大值。
     *
     * 连续子序列的最大和主要由这三部分子区间里元素的最大和得到：
     * 第 1 部分：子区间 [left, mid]；
     * 第 2 部分：子区间 [mid + 1, right]；
     * 第 3 部分：包含子区间 [mid , mid + 1] 的子区间，即 nums[mid] 与 nums[mid + 1] 一定会被选取。
     * 对它们三者求最大值即可。
     */

    public int maxSubArray2(int[] nums) {
        return maxSubArrayDivideWithBorder(nums, 0, nums.length-1);
    }

    private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
        if (start == end) {
            // 只有一个元素，也就是递归的结束情况
            return nums[start];
        }

        // 计算中间值
        int center = (start + end) / 2;
        int leftMax = maxSubArrayDivideWithBorder(nums, start, center); // 计算左侧子序列最大值
        int rightMax = maxSubArrayDivideWithBorder(nums, center + 1, end); // 计算右侧子序列最大值

        // 下面计算横跨两个子序列的最大值

        // 计算包含左侧子序列最后一个元素的子序列最大值
        int leftCrossMax = Integer.MIN_VALUE; // 初始化一个值
        int leftCrossSum = 0;
        for (int i = center ; i >= start ; i --) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossSum, leftCrossMax);
        }

        // 计算包含右侧子序列最后一个元素的子序列最大值
        int rightCrossMax = nums[center+1];
        int rightCrossSum = 0;
        for (int i = center + 1; i <= end ; i ++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossSum, rightCrossMax);
        }

        // 计算跨中心的子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;

        // 比较三者，返回最大值
        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }
}

/**
 * 在计算过程中，累加和比较的过程是关键操作，一个长度为 n 的数组在递归的每一层都会进行 n 次操作，
 * 分治法的递归层级在logN 级别，所以整体的时间复杂度是O(nlogn)，在时间效率上不如动态规划的O(n) 复杂度。
 */
