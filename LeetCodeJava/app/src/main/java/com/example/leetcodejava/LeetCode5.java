package com.example.leetcodejava;

public class LeetCode5 {

    /**
     * 5、最长回文子串    easy
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
        if (s.isEmpty()) {
            return s;
        }
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = ans.length();
                }
            }
        return ans;
    }

    /**
     *   时间复杂度：两层for循环O(n²），for循环里边判断是否为回文 O(n），所以时间复杂度为 O(n³）。
     *   空间复杂度：O(1），常数个变量
     */


    /**
     * 解法 2
     * 最简单直观的方法是遍历字符串，遍历的时候以每个字符为中心向左右两侧扩散
     * 对于奇数，我们以该字符为中心向两边扩散；对于偶数，我们以该字符和下一个字符作为中心字符，然后向两边扩散。
     */
    // ps : https://www.nowcoder.com/discuss/196952?type=0&order=0&pos=28&page=0
    private int start = 0, maxLen = 0;

    public String longestPalindrome2(String s) {
        if(s.length() < 1)
            return s;

        for(int i=0; i<s.length(); i++){
            // 回文子串为奇数时，查找最长回文子串
            extendPalindrome(s, i, i);
            // 回文子串为偶数时，查找最长回文子串
            extendPalindrome(s, i, i+1);
        }

        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int left, int right){
        // 判断是否为回文子串，若是，则左指针向左移动，右指针向右移动
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        // 回文子串查找完成后，判断刚刚查找的回文子串是否为最长回文子串，若是，则更新起始位置和最长长度
        if(maxLen < right-left-1){
            start = left + 1;
            maxLen = right -left - 1;
        }
    }
    /**
     * 整个算法流程的时间复杂度为O(n^2)，空间复杂度为O(1)。
     */
}
