package com.example.leetcodejava.Algorithm.BinarySearch;

public class LeetCode278 {
    /**
     *  LeetCode278.第一个错误的版本  Easy
     *
     *  你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
     *  由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *  假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *  你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
     *  实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     *  示例:
     *  给定 n = 5，并且 version = 4 是第一个错误的版本。
     *
     *  调用 isBadVersion(3) -> false
     *  调用 isBadVersion(5) -> true
     *  调用 isBadVersion(4) -> true
     *
     *  所以，4 是第一个错误的版本。 
     */

    // ps:isBadVersion方法是题目中给出的可调用的方法，此处新加一个isBadVersion方法为了不报错
    public boolean isBadVersion(int n) {
        return true;
    }

    /**
     * 二分查找
     * 如果第 m 个版本出错，则表示第一个错误的版本在 [left, m] 之间，令 right = m；
     * 否则，第一个错误的版本在 [m + 1, right] 之间，令 left = m + 1。
     * 因为 right 的赋值表达式为 right = m，因此循环条件为 left < right。
     *
     * 在二分查找的每次操作中，我们都用left 和 right 表示搜索空间的左右边界，因此在初始化时，
     * 需要将left 的值设置为 1，并将right 的值设置为 n。当某一次操作后，left 和 right的
     * 值相等，此时它们就表示了第一个错误版本的位置。可以用数学归纳法 证明 二分查找算法的正确性。
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    /**
     *  复杂度分析
     *  时间复杂度：O(logn)。搜索空间每次减少一半，因此时间复杂度为O(logn)。
     *  空间复杂度：O(1)。
     */
}
