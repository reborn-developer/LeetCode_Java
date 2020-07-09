package com.example.leetcodejava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LeetCode17_13 {
    /**
     *  LeetCode 面试题 17.13. 恢复空格
     *
     *  哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
     *  像句子"I reset the computer. It still didn’t boot!"已经变成了
     *  "iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。
     *  当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，
     *  设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     *
     * 示例：
     *
     * 输入：
     * dictionary = ["looked","just","like","her","brother"]
     * sentence = "jesslookedjustliketimherbrother"
     * 输出： 7
     * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     *
     * 提示：
     * 0 <= len(sentence) <= 1000
     * dictionary中总字符数不超过 150000。
     * 你可以认为dictionary和sentence中只包含小写字母。
     */

    /**
     * 方法一、采用动态规划
     创建一个数组dp[]用来记录结果。句子从前往后看，其中dp[0]=0表示句子是空字符串时没有未识别的字符，
     dp[i]表示句子前i个字符中最少的未识别字符数。
     然后来找状态转移方程。对于前i个字符，即句子字符串的[0,i)，它可能是由最前面的[0,j)子字符串加上一个字典匹配的单词得到，
     也就是dp[i]=dp[j], j<i；也可能没找到字典中的单词，可以用它前i-1个字符的结果加上一个没有匹配到的第i个字符，即dp[i]=dp[i-1]+1。
     要注意的是，即使前面存在匹配的单词，也不能保证哪一种剩下的字符最少，所以每轮都要比较一次最小值。
     */
    public int respace1(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        for(String str: dictionary) dic.add(str);

        int n = sentence.length();
        //dp[i]表示sentence前i个字符所得结果
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1]+1;  //先假设当前字符作为单词不在字典中
            for(int j=0; j<i; j++){
                if(dic.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}
