package com.example.leetcodejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode315 {
    /**
     *  LeetCode315.315. 计算右侧小于当前元素的个数
     *
     *  给定一个整数数组 nums，按要求返回一个新数组 counts。
     *  数组 counts 有该性质：
     *  counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     *  示例:
     *
     * 输入: [5,2,6,1]
     * 输出: [2,1,1,0]
     * 解释:
     * 5 的右侧有 2 个更小的元素 (2 和 1).
     * 2 的右侧仅有 1 个更小的元素 (1).
     * 6 的右侧有 1 个更小的元素 (1).
     * 1 的右侧有 0 个更小的元素.
     */

    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<Integer>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }

        return ret;
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }
}
