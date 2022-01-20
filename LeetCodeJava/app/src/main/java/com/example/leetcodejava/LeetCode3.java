package com.example.leetcodejava;

import java.util.HashMap;

/**
 * leetCode3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LeetCode3 {
    /**
     * 思路：
     *
     * 这道题主要用到思路是：滑动窗口
     *
     * 什么是滑动窗口？
     *
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     *
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     *
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度：O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0; //最长子串长度
        int left = 0; //滑动窗口左下标，i相当于滑动窗口右下标
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){//charAt() 方法用于返回指定索引处的字符。索引范围为从0到length()-1。
                // map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                // map.get('a')=0,因为map中只有第一个a的下标，
                // 然后更新left指针到原来left的的下一位
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1); //比较两个参数的大小
        }
        return max;
    }
}
