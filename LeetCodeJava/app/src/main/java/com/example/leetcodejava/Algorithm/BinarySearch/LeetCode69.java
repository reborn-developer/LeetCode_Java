package com.example.leetcodejava.Algorithm.BinarySearch;

public class LeetCode69 {
    /**
     *  LeetCode69.实现 int sqrt(int x) 函数。
     *  计算并返回 x 的平方根，其中 x 是非负整数。
     *  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     *  示例 1:
     *  输入: 4
     *  输出: 2
     *
     *  示例 2:
     *  输入: 8
     *  输出: 2
     *  说明: 8 的平方根是 2.82842...,
     *       由于返回类型是整数，小数部分将被舍去。
     */

    /**
     * 二分查找
     * 由于 x平方根的整数部分 \textit{ans}ans 是满足 k^2 ≤ x的最大 k 值
     * 因此我们可以对 k进行二分查找，从而得到答案。
     *
     * 二分查找的下界为 0，上界可以粗略地设定为 x。
     * 在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，并通过比较的结果调整上下界的范围。
     * 由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案ans 后，也就不需要再去尝试ans+1 了
     */
    public int mySqrt(int x) {
        int start = 0, end = x, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
    /**
     * 复杂度分析
     *
     * 时间复杂度：O(logx)，即为二分查找需要的次数。
     *
     * 空间复杂度：O(1)。
     */
}
