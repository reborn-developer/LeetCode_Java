package com.example.leetcodejava;

import java.util.Arrays;

public class LeetCode242 {
    /**
     * LeetCode242.给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */

    /**
     *  方法一:排序
     *  思路：
     *
     *  通过将s的字母重新排列成t来生成变位词。因此，如果T是S的变位词，对两个字符串进行排序将产生两个相同的字符串。
     *  此外，如果s 和 t的长度不同，t 不能是 s 的变位词，我们可以提前返回。
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    /**
     *  复杂度分析
     *
     *  时间复杂度：O(nlogn)，假设n是s的长度，排序成本O(nlogn) 和比较两个字符串的成本O(n)。排序时间占主导地位，总体时间复杂度为O(nlogn)。
     *  空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要O(1) 辅助空间。
     *  注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费O(n)额外的空间，但是我们忽略了这一复杂性分析，因为：
     *  这依赖于语言的细节。
     *  这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
     *
     */


}
