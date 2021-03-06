package com.example.leetcodejava;

import java.util.ArrayList;
import java.util.List;

public class LeetCode6 {
    /**
     * 6、Z 字形变换
     *
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     *
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     */


    /**
    * 解题思路：
     * 题目理解：
     * 字符串s是以Z字形为顺序存储的字符串，目标是按行打印。
     * 设 numRows 行字符串分别为 s1,s2...,sn
     * 则容易发现：按顺序遍历字符串s时，每个字符c在Z字形中对应的 行索引 先从s1增大到sn，
     * 再从sn减小到s1....如此反复。
     * 因此，解决方案为：模拟这个行索引的变化，在遍历s中把每个字符填到正确的行 res[i] 。
     *
     * 算法流程： 按顺序遍历字符串 s；
     * res[i] += c： 把每个字符 c 填入对应行si
     * i += flag： 更新当前字符 c 对应的行索引；
     * flag = - flag： 在达到 Z字形转折点时，执行反向。
     *
     * 复杂度分析：
     * 时间复杂度 O(N)：遍历一遍字符串 s；
     * 空间复杂度 O(N)：各行字符串共占用 O(N)额外空间。
    */

    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
