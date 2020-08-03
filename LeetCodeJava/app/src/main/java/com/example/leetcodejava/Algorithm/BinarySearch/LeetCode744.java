package com.example.leetcodejava.Algorithm.BinarySearch;

public class LeetCode744 {
    /**
     * LeetCode744. 寻找比目标字母大的最小字母
     *
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
     *
     * 在比较时，字母是依序循环出现的。举个例子：
     *
     * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
     *
     * 示例：
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "a"
     * 输出: "c"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "c"
     * 输出: "f"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "d"
     * 输出: "f"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "g"
     * 输出: "j"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "j"
     * 输出: "c"
     *
     * 输入:
     * letters = ["c", "f", "j"]
     * target = "k"
     * 输出: "c"
     *
     * 提示：
     *
     * letters长度范围在[2, 10000]区间内。
     * letters 仅由小写字母组成，最少包含两个不同的字母。
     * 目标字母target 是一个小写字母。
     */

    /**
     * 给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start < n ? letters[start] : letters[0];
    }
    /**
     * 复杂度分析
     *
     * 时间复杂度：O(logN)，即为二分查找需要的次数。
     *
     * 空间复杂度：O(1)。
     */
}
