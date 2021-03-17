package com.example.leetcodejava;
/**
 *  LeetCode 面试题 17.21. 直方图的水量
 *  给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *  上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水)
 */
class LeetCode17_21 {

    // ps:经过分析，第一个和最后一个元素不可能存水，水量为0

    /**
     * 第一版，未优化
     * 时间复杂度O（N^2）
     */
    public static int trap1(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int N = height.length;
        int water = 0;
        for (int i = 1; i < N - 1 ;i++) {
            // 分别循环找i位置左边的最大值，找i位置右边的最大值
            int leftMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < N; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // 对应每个位置的储水量  Math.min(leftMax, rightMax) - height[i]
            water += Math.max(Math.min(leftMax, rightMax) - height[i], 0);
        }
        return water;
    }

    /**
     * 第二版，优化版 预处理数组技巧
     * 时间复杂度O（N）
     */
    public static int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int N = height.length;
        int[] leftMaxs = new int[N];
        leftMaxs[0] = height[0];

        // 预先处理，方便最后直接数组查找i位置左边的最大值，i位置右边最大值
        for (int i = 1; i < N; i++) {
            // leftMaxs[i] 代表0~i的最大值
            leftMaxs[i] = Math.max(leftMaxs[i - 1],height[i]);
        }

        int[] rightMaxs = new int[N];
        rightMaxs[N-1] = height[N-1];
        for (int i  = N - 2; i >= 0; i--) {
            // rightMaxs[i] 代表i ~ N-1 的最大值
            rightMaxs[i] = Math.max(height[i], rightMaxs[i+1]);
        }

        int water = 0;
        for (int i = 1; i < N - 1; i++) {
            water += Math.max(Math.min(leftMaxs[i-1], rightMaxs[i+1]) - height[i], 0);
        }
        return water;
    }

    /**
     * 第三版，最优解  双指针法
     * 时间复杂度O（N）
     */
    public static int trap3(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int N = height.length;
        int L = 1;
        int leftMax = height[0];
        int R = N - 2;
        int rightMax = height[N-1];
        int water = 0;
        while (L <= R) {
            if (leftMax <= rightMax) { // 谁小取谁的值，小的值是瓶颈，最多可存的水
                water += Math.max(0, leftMax - height[L]);
                leftMax = Math.max(leftMax, height[L++]);
            } else {
                water += Math.max(0, rightMax - height[R]);
                rightMax = Math.max(rightMax, height[R--]);
            }
        }
        return water;
    }
}
