package com.example.leetcodejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode970 {
    /**
     * LeetCode970.强整数
     * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，
     * 其中整数i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
     * 返回值小于或等于 bound 的所有强整数组成的列表。
     * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
     *
     * 示例 1
     * 输入：x = 2, y = 3, bound = 10
     * 输出：[2,3,4,5,7,9,10]
     * 解释：
     * 2 = 2^0 + 3^0
     * 3 = 2^1 + 3^0
     * 4 = 2^0 + 3^1
     * 5 = 2^1 + 3^1
     * 7 = 2^2 + 3^1
     * 9 = 2^3 + 3^0
     * 10 = 2^0 + 3^2
     *
     * 示例 2：
     * 输入：x = 3, y = 5, bound = 15
     * 输出：[2,4,6,8,10,14]
     *
     * 提示：
     * 1 <= x <= 100
     * 1 <= y <= 100
     * 0 <= bound <= 10^6
     */

    /**
     * 思路：
     * 根据数学中的换底公式获取到i和j的最大值，这里要注意的是两者中有为1的情况的话要单独处理
     * 双重循环i和j，得到其中的一个强整数，当已经超过bound时可以跳出内层循环节省时间
     * 保存的结果用set自动去重，最后转换为list
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        int iMax = x == 1 ? 0 : (int)(Math.log(bound-1) / Math.log(x));
        int jMax = y == 1 ? 0 : (int)(Math.log(bound-1) / Math.log(y));

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= iMax; i++) {
            for (int j = 0; j <= jMax; j++) {
                if (Math.pow(x,i) + Math.pow(y,j) <= bound) {
                    set.add((int)(Math.pow(x,i) + Math.pow(y,j)));
                } else break;
            }
        }
        return new ArrayList<>(set);
    }
}
