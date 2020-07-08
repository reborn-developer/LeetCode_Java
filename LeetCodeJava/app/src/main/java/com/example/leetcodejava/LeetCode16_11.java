package com.example.leetcodejava;

public class LeetCode16_11 {

    /**
     *  LeetCode面试题 16.11. 跳水板
     *
     *  你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     *
     *  返回的长度需要从小到大排列。
     *
     *  示例：
     *  输入：
     *  shorter = 1
     *  longer = 2
     *  k = 3
     *  输出： {3,4,5,6}
     *
     *  提示：
     *  0 < shorter <= longer
     *  0 <= k <= 100000
     */

    /**
     * 方法：数学归纳法
     * 首先考虑两种边界情况。
     *
     * 如果 k=0，则不能建造任何跳水板，因此返回空数组。
     *
     * 如果 shorter和 longer相等，则建造的跳水板的长度是唯一的，
     * 都等于 shorter*k，因此返回长度为 1的数组，数组中的元素为 shorter*k。
     *
     * 然后考虑一般情况，即 shorter<longer 且k>0。由于短木板和长木板一共使用 k块，
     * 因此一共有 k+1 种组合，每种组合下建造的跳水板长度都是不一样的，一共有 k+1种不同的长度。
     **/

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }
    /**
     *  复杂度分析
     *
     * 时间复杂度：O(k)，其中 k是木板数量。短木板和长木板一共使用 k块，一共有 k+1 种组合，对于每种组合都要计算跳水板的长度。
     *
     * 空间复杂度：O(1)。除了返回值以外，额外使用的空间复杂度为常数。
     *
     */

}
