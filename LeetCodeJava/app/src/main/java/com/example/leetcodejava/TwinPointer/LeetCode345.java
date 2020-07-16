package com.example.leetcodejava.TwinPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LeetCode345 {
    /**
     * LeetCode345. 反转字符串中的元音字母   easy
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 示例 1:
     *
     * 输入: "hello"
     * 输出: "holle"
     *
     * 示例 2:
     *
     * 输入: "leetcode"
     * 输出: "leotcede
     *
     * 说明:
     * 元音字母不包含字母"y"。
     */

    /**
     * 思路
     * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
     *
     * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
     *
     * 时间复杂度为 O(N)：只需要遍历所有元素一次
     * 空间复杂度 O(1)：只需要使用两个额外变量
     */

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            char leftValue = s.charAt(leftIndex);
            char rightValue = s.charAt(rightIndex);
            if (!vowels.contains(leftValue)) {
                leftIndex++;
            } else if (!vowels.contains(rightValue)) {
                rightIndex--;
            } else {
                chars[leftIndex] = rightValue;
                chars[rightIndex] = leftValue;
                leftIndex++;
                rightIndex--;
            }
        }
        return new String(chars);
    }

}
