package com.example.leetcodejava.Algorithm.BinarySearch;

public class BinarySearch {
    /**
     *  二分查找
     *
     *  Input : [1,2,3,4,5]
     *  key : 3
     */
    public int binarySearch(int[] nums, int key) {
        int start = 0, end = nums.length - 1;
        while (start<= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 时间复杂度
     * 二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)
     *
     * m 计算
     * 有两种计算中值 m 的方式：
     *
     * m = (start + end) / 2
     * m = start + (end - start) / 2
     * start + end 可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围。
     * 但是 start 和 end 都为正数，因此 end - start 不会出现加法溢出问题。所以，最好使用第二种计算法方法。
     */
}
