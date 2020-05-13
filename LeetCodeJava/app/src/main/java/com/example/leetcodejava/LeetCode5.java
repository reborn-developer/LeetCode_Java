package com.example.leetcodejava;

public class LeetCode5 {

    /**
     * 5、最长回文子串
     *
     * 给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */


    /**
     * 解法 1: 暴力破解
     * 暴力求解，列举所有的子串，判断是否为回文串，保存最长的回文串。
     */
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

    /**
     *   时间复杂度：两层for循环O(n²），for循环里边判断是否为回文 O(n），所以时间复杂度为 O(n³）。
     *   空间复杂度：O(1），常数个变量
     */


}
