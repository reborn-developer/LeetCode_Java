package com.example.leetcodejava;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    /**
     * 179.最大数
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     *
     * 示例 1:
     * 输入: [10,2]
     * 输出: 210
     *
     * 示例 2:
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     *
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */

    /**
     *  思路：
     *  直觉上，我们应该先选最高位大的数。举个例子，比如对于 5,914,67，先选 914，再选 67，再选 5，组成 914675，
     *  因为数字的高位越大越好，每次尽量选高位的大的数从而保证了最后构成的数一定是最大的。
     *
     *  接下来的一个问题，如果最高位的数字一样呢？又分成两种情况。
     *  如果两个数字长度相等，比如 34 和 30 ， 那么很明显，选择较大的即可。
     *  如果两个数字长度不相等，比如 3 和 30，此时先选择 3 还是先选择 30 呢？
     *
     *  我们只需要把它两拼接在一起直接去比较，也就是比较 330 和 303，很明显是 330 大，所以我们先选择 3。
     *  所以我们可以封装一个比较函数。
     *
     *  因此
     *  我们直接调用系统的排序方法，传一个我们自定义的比较器即可。
     *  此外，因为我们要从大到小排列，所以前一个数字大于后一个数字的时候，我们应该返回 -1。
     */

    public String largestNumber(int[] nums) {

        //自带的比较器不能使用 int 类型，所以我们把它转为 Integer 类型
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                int len1 = (n1 + "").length();
                int len2 = (n2 + "").length();
                if (len1 == len2) {
                    if (n1 > n2) {
                        return -1;
                    } else if (n1 < n2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                int combination1 = (int) (n1 * Math.pow(10, len2)) + n2;
                int combination2 = (int) (n2 * Math.pow(10, len1)) + n1;

                if (combination1 > combination2) {
                    return -1;
                } else if (combination1 < combination2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(n[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }

    /**
     *  分析一下时间复杂度
     *  如果是快速排序，那么就是 O（nlog(n)，此外我们的比较函数因为要求出每个数字的长度，
     *  我们需要遍历一遍数字，记做 O（k），所以总的时间复杂度对于快排的话就是 O(nklon(n))。
     *
     */

}
