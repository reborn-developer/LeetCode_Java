package com.example.leetcodedemo_java;

public class LeetCode14 {

    public String testLeedtCode14() {
        String[] target = {"flower", "flow", "flight"};

        System.out.print(longestCommonPrefix(target));

        return longestCommonPrefix(target);
    }

    /*
     * 14.最长公共前缀
     *
     * 题意分析:
     (1) 公共前缀指两字符串开头相同的部分。
     (2) 字符串数组中的最长公共前缀就是数组中所有字符串开头相同的部分。
     *** 简单思考就是分别匹配每个字符串前缀的过程。
     * 思路：
     (1) 取数组中一个字符串作为匹配串去循环匹配数组中其它字符串。
     (2) 发生不匹配就截去匹配串最后一个字符继续循环，匹配完成就匹配下一个字符串，直到最后。
     (3) 如果匹配串在匹配过程中长度被截为 0 ，则直接返回不匹配。
     * */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        // 字符串可以被自身匹配，所以从第二个开始匹配。
        for (int i = 1; i < strs.length; i++) {
            // 如果匹配串不在要匹配字符串的开头，则表示不是要匹配字符串的前缀。
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /*
     * 1、int indexOf(String str) :返回第一次出现的指定子字符串在此字符串中的索引
     * 2、str.substring(int beginIndex，int endIndex);
     * 截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
     * */

    /*
    * 复杂度分析

      时间复杂度：O(S)O(S)，S 是所有字符串中字符数量的总和。

      最坏的情况下，nn 个字符串都是相同的。算法会将 S1与其他字符串都做一次比较。这样就会进行S次字符比较，其中S是输入数据中所有字符数量。

      空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
    *
    *
    * */
}
