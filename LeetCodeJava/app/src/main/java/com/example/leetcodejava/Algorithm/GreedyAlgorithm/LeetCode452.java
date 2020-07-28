package com.example.leetcodejava.Algorithm.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {

    /**
     *  LeetCode452.用最少数量的箭引爆气球
     *  在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
     *  由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
     *
     *  一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
     *  且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
     *  我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     *
     *  Example:
     *
     *  输入:
     *  [[10,16], [2,8], [1,6], [7,12]]
     *  输出:
     *  2
     *  解释:
     *  对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
     */

    /**
     * 方法：贪心算法
     * 贪心算法一般用来解决需要 “找到要做某事的最小数量” 或 “找到在某些情况下适合的最大物品数量” 的问题，且提供的是无序的输入。
     * 思路：
     * 让我们根据气球的结束坐标进行排序，然后一个个进行检查
     * 这代表了我们可以跟踪气球的结束坐标，若下个气球开始坐标在当前气球的结束坐标前，则我们可以用一支箭一起引爆；
     * 若下个气球的开始坐标在当前气球的结束坐标后，则我们必须增加箭的数量。并跟踪下个气球的结束坐标。
     *
     * 其实也是计算不重叠的区间个数，不过和LeetCode435的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
//        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(NlogN)。因为对输入数据进行了排序。
     * 空间复杂度：O(1)，仅仅使用了常数空间。
     */

}
