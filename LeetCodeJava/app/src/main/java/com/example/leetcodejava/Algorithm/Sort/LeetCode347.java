package com.example.leetcodejava.Algorithm.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode347 {
    /**
     *  LeetCode347. 前 K 个高频元素
     *  给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *  示例 1:
     *  输入: nums = [1,1,1,2,2,3], k = 2
     *  输出: [1,2]
     *
     *  示例 2:
     *  输入: nums = [1], k = 1
     *  输出: [1]
     *
     *  提示：
     *
     *  你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     *  你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     *  题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     *  你可以按任意顺序返回答案。
     */

    /**
     * 可以发现，使用常规的诸如 冒泡、选择、甚至快速排序都是不满足题目要求，它们的时间复杂度都是大于或者等于O(nlog⁡n)，
     * 而题目要求算法的时间复杂度必须优于 O(n log n)。
     */

    /**
     *  方法一、最小堆
     *
     *  题目最终需要返回的是前 k个频率最大的元素，可以想到借助堆这种数据结构，对于 k频率之后的元素不用再去处理，进一步优化时间复杂度。
     *
     *  具体操作为：
     *  借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
     *  维护一个元素数目为 k 的最小堆
     *  每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
     *  如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
     *  最终，堆中的 k 个元素即为前 k个高频元素
     *
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        final HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];

        int index = 0;
        while (!pq.isEmpty()) {
            res[index] = pq.remove();
            index ++;
        }
        return res;
    }
    /**
     * 复杂度分析
     * 时间复杂度：O(nlogk)，n表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)；
     * 接着，遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，则将顶部的元素删除并将该元素加入堆中，
     * 这里维护堆的数目是 k，所以这一系列操作的时间复杂度是 O(nlogk) 的；因此，总的时间复杂度是O(nlog⁡k)。
     *
     * 空间复杂度：O(n)，最坏情况下（每个元素都不同），map 需要存储 n个键值对，优先队列需要存储 k个元素，因此，空间复杂度是 O(n)。
     */

    /**
     * 解法二：桶排序法
     * 首先依旧使用哈希表统计频率，统计完成后，创建一个数组，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可。
     *
     * 首先创建一个 Map 记录数组中每个元素的频率
     *
     * 然后创建一个数组将元素按照频率升序存放在 list 中
     *
     * 定义 i 来接收每个元素的频率，并且元素就按照自己的频率作为数组的下标存储
     *
     * 最后对数组逆向求出前 k个高频率的元素，放入结果集 ans 即可。
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(n)，n 表示数组的长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)；
     * 桶的数量为 n + 1，所以桶排序的时间复杂度为 O(n)；因此，总的时间复杂度是 O(n)。
     * 空间复杂度：很明显为 O(n)
     */
}
