package com.example.leetcodejava.TwinPointer;

public class LeetCode633 {
    /**
     * LeetCode633. 平方数之和
     *
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
     *
     * 示例1:
     *
     * 输入: 5
     * 输出: True
     * 解释: 1 * 1 + 2 * 2 = 5
     *
     * 示例2:
     *
     * 输入: 3
     * 输出: False
     *
     */

    /**
     * 方法一、双指针
     * 可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target，如果能找到，则返回 true，表示 target 是两个整数的平方和。
     *
     * 本题和 167. Two Sum II - Input array is sorted 类似，只有一个明显区别：一个是和为 target，一个是平方和为 target。本题同样可以使用双指针得到两个数，使其平方和为 target。
     *
     * 本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。设右指针为 x，左指针固定为 0，为了使 0^2 + x^2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
     *
     * 因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。
     */
    public boolean judgeSquareSum(int target) {

        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * 方法二、二分查找
     * 我们可以首先枚举 a，并保证 c - a^2 >= 0，随后我们通过二分查找的方法找出是否存在 b，满足 b^2 = c - a^2。二分查找的范围为 [0, c - a^2]。
     *
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }

    public boolean  binary_search(long left, long right, int n) {
        if (left > right)
            return false;
        long mid = left + (right - left)/2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(left, mid -1, n);
        return binary_search(mid +1, right, n);
    }
    /**
     * 复杂度分析
     *
     * 时间复杂度：O(sqrt{c}logc) 其中枚举 a 的时间复杂度为 O(sqrt{c}),二分查找的时间复杂度为O(logc)
     * 空间复杂度：O(logc)。代码中使用递归的方式实现二分查找，也可以优化到 O(1)。
     */
}