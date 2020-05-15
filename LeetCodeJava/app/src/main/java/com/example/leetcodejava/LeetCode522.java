package com.example.leetcodejava;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode522 {

    /**
     *  522. 最长特殊序列 II
     *  给定字符串列表，你需要从它们中找出最长的特殊序列。
     *  最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
     *  子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。
     *  空序列为所有字符串的子序列，任何字符串为其自身的子序列。
     *  输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
     *
     *  示例：
     *  输入: "aba", "cdc", "eae"
     *  输出: 3
     *
     *  提示：
     *  1、所有给定的字符串长度不会超过 10 。
     *  2、给定字符串列表的长度将在 [2, 50 ] 之间。
     *
     */

    // break用于完全结束一个循环，跳出循环体执行循环后面的语句；
    // 而continue是跳过当次循环中剩下的语句，执行下一次循环。
    // 简单点说就是break完全结束循环，continue终止本次循环。

    /**
     *   方法一：检查每个字符串
     *   如果存在这样的特殊序列，那么它一定是某个给定的字符串。
     *   检查每个字符串是否是其他字符串的子序列。如果不是，则它是一个特殊序列。最后返回长度最大的特殊序列。如果不存在特殊序列，返回 -1。
     */
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i)
                    continue;
                if (isSubsequence(strs[i], strs[j]))
                    break;
            }
            if (j == strs.length)
                res = Math.max(res, strs[i].length());
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; j < s.length() && i < t.length(); i++)
            if (s.charAt(j) == t.charAt(i))
                j++;
        return j == s.length();
    }

    /**
     *   复杂度分析
     *   时间复杂度：O(x*n^2)其中 n是字符串的数量，x是每个字符串的平均长度。
     *   空间复杂度：O(1)，恒定的额外空间。
     */


    /**
     *   方法二：排序+检查每个字符串
     *   方法一中需要判断每个字符串是否为特殊序列。如果最开始可以先将所有字符串排序，则可以节省一部分计算。
     *   本方法中，首先按照长度降序排序所有字符串。然后，依次使用序列中的每个字符串与其他字符串比较，如果不存在字符串是当前字符串的子序列，则返回当前字符串的长度。否则返回 -1。
     */
    public int findLUSlength2(String[] strs) {
        Arrays.sort(strs, new Comparator< String >() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        for (int i = 0, j; i < strs.length; i++) {
            boolean flag = true;
            for (j = 0; j < strs.length; j++) {
                if (i == j)
                    continue;
                if (isSubsequence(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return strs[i].length();
        }
        return -1;
    }

    /**
     *   复杂度分析
     *   时间复杂度：O(x*n^2)其中 n 是字符串的数量，x 是每个字符串的平均长度。
     *   空间复杂度：O(1)，恒定的额外空间。
     */
}
