package com.example.leetcodejava;

import java.util.HashMap;
import java.util.Map;
/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 */
public class LeetCode1 {
    // 方法一：暴力枚举
     public int[] twoSum1(int[] nums, int target) {
         int n = nums.length;
         for (int i = 0; i < n; ++i) {
             for (int j = i + 1; j < n; ++j) {
                 if (nums[i] + nums[j] == target) {
                     return new int[]{i, j};
                 }
             }
         }
         return new int[0];
     }
     /*
     * 复杂度分析
      时间复杂度：O(N^2)，其中N是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
      空间复杂度：O(1)
     * */

    /* 方法二：哈希表
    * 注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。
    * 因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。
    * 如果存在，我们需要找出它的索引。
    * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从O(N)降低到O(1)
    * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
    * 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
    * 时间复杂度：O(N)，其中 N是数组中的元素数量。对于每一个元素 x，我们可以O(1)地
    * 寻找 target - x。
      空间复杂度：O(N)，其中N是数组中的元素数量。主要为哈希表的开销。
    * */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
