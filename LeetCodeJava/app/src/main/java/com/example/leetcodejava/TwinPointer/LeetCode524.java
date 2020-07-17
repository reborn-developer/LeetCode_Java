package com.example.leetcodejava.TwinPointer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode524 {

    /**
     * LeetCode524.通过删除字母匹配到字典里最长单词    Medium
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
     * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     *
     * 示例 1:
     * 输入:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     *
     * 输出:
     * "apple"
     *
     * 示例 2:
     * 输入:
     * s = "abpcplea", d = ["a","b","c"]
     *
     * 输出:
     * "a"
     *
     * 说明:
     * 1、所有输入的字符串只包含小写字母。
     * 2、字典的大小不会超过 1000。
     * 3、所有输入的字符串长度不会超过 1000。
     *
     * */

    /**
     * 解法一、双指针
     * 这题的关键就是怎么在字符串字典中找到那个对应的字符串。其实很简单。
     * 只要利用两个指针i,j，一个指向s字符串，一个指向sstr字符串，
     * 每一次查找过程中,i依次后移，若i,j对应的两个字符相等，则j后移，
     * 如果j可以移到sstr.length()，那么说明sstr中对应的字符s中都有，
     * 即s中删除一些字符后，可以得到sstr字符串，
     * 最后一步就是比较当前的结果字符与找到的sstr字符，按照题目的需求来决定是否改变结果字符，是不是还挺简单的呀。
     *
    * */

    public String findLongestWord(String s, List<String> d) {
        String result="";
        for(String sstr:d){
            for(int i=0,j=0;i<s.length()&&j<sstr.length();i++){
                if(s.charAt(i)==sstr.charAt(j)) j++;
                if(j==sstr.length()){
                    if(sstr.length()>result.length()||(sstr.length()==result.length()&&result.compareTo(sstr)>0))  result=sstr;
                }
            }
        }
        return result;
    }

    /**
     * 解法二、排序并检查子序列
     *
     * 算法
     * 问题中匹配的条件是我们需要考虑字典中能匹配的最长字符串，相同长度的情况下考虑字典序最小的。
     * 为了简化搜索过程，我们把字典中的字符串按照这一规则排序，这样越靠前的字符串是我们越优先考虑的。
     *
     * 现在，与其删除s中的字符，我们直接从头开始检查字典中的单词是否是s串的子序列。
     * 这是因为，如果x是s的子序列，我们可以直接通过删除 s中的某些字符得到 x 。
     *
     * 如果x是s的子序列，那么x中的每个字符在 s中出现过。
     *
     */

    public String findLongestWord2(String s, List < String > d) {
        Collections.sort(d, new Comparator< String >() {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String t: d) {
            if (isSubsequence(s, t))
                return t;
        }
        return "";
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == t.length();
    }

    /**
     *  复杂度分析
     *
     *  时间复杂度： O(n * xlog n + n*x)O。这里，n表示列表d中字符串的数目，x表示字符串的平均长度。
     *  排序需要花费O(nlogn) 的时间， isSubsequence 函数需要花费O(x)的时间去检查一个字符串是否是另一个字符串的子序列。
     *
     *  空间复杂度： O(log n)。排序平均需要O(log n)的空间。
     *
     */



}
