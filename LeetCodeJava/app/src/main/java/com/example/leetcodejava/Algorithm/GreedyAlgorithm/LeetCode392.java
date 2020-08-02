package com.example.leetcodejava.Algorithm.GreedyAlgorithm;

public class LeetCode392 {

    /**
     * LeetCode392. 判断子序列  Easy
     *
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * 返回 true.
     *
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * 返回 false.
     *
     * 后续挑战 :
     *
     * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     */

    /**
     * 双指针+贪心算法
     *
     * 思路及算法
     *
     * 本题询问的是，s是否是 t 的子序列，因此只要能找到任意一种 s 在t中出现的方式，即可认为 s 是 t 的子序列。
     * 而当我们从前往后匹配，可以发现每次贪心地匹配靠前的字符是最优决策。
     *
     * 这样，我们初始化两个指针 i 和 j，分别指向 s和 t的初始位置。
     * 每次贪心地匹配，匹配成功则 i 和 j同时右移，匹配 s的下一个位置，匹配失败则 j右移，i 不变，尝试用 t 的下一个字符匹配 s。
     * 最终如果 i 移动到 s 的末尾，就说明 s是t的子序列。
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(n+m)，其中 n 为 s 的长度，m为 t 的长度。每次无论是匹配成功还是失败，都有至少一个指针发生右移，两指针能够位移的总距离为 n+m。
     *
     * 空间复杂度：O(1)。
     */
}
