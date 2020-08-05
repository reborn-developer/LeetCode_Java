package com.example.leetcodejava.Algorithm.BinarySearch;

public class LeetCode34 {
    /**
     *  LeetCode34.在排序数组中查找元素的第一个和最后一个位置  Medium
     *
     *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     *  你的算法时间复杂度必须是 O(log n) 级别。
     *
     *  如果数组中不存在目标值，返回 [-1, -1]。
     *
     *  示例 1:
     *  输入: nums = [5,7,7,8,8,10], target = 8
     *  输出: [3,4]
     *
     *  示例 2:
     *  输入: nums = [5,7,7,8,8,10], target = 6
     *  输出: [-1,-1]
     */

    /**
     *  方法一
     *  可以用二分查找找出第一个位置和最后一个位置，但是寻找的方法有所不同，需要实现两个二分查找。
     *  我们将寻找 target 最后一个位置，转换成寻找 target+1 第一个位置，再往前移动一个位置。
     *  这样我们只需要实现一个二分查找代码即可。
     */
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length; // 注意 right 的初始值
        while (left < right) {
            int m = left + (right - left) / 2;
            if (nums[m] >= target) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return left;
    }

    /**
     * 方法二
     */
    public int[] searchRange2(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    /**
     * 寻找左侧边界的二分搜索
     */
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        // 当 target 比 nums 中所有元素都大时，会存在索引越界：
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    /**
     * 寻找右侧边界的二分搜索
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，
        // 当 target 比所有元素都小时，right 会被减到 -1，所以需要在最后防止越界：
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    /**
     * 方法三
     * 取另一种边界的方法(right = nums.length)
     */
    int left_bound2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }

//        return left; // 注意

        // target 比所有数都大
        if (left == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }

    int right_bound2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
//        return left - 1; // 注意

        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;  // 注意
    }

}
