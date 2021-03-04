package com.example.leetcodejava.Algorithm.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * 桶排序的性能并非绝对稳定。如果元素的分布极不均衡，在极端情况下，第一个桶中有n-1个元素，
 * 最后一个桶中有1个元素。此时的时间复杂度将退化为O(nlogn)，而且还白白创建了许多空桶。
 */
public class BucketSort {

    public static double[] bucketSort(double[] array) {

        //1.得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];

        for (int  i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        double d = max - min;

        //2.初始化桶
        // 具体需要建立多少个桶，如何确定桶的区间范围，有很多种不同的方式。我们这里创建的桶数量等于原始数列的元素数量
        int bucketNum = array.length;

        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        //3.遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //4.对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            //JDK 底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;

        for (LinkedList<Double> list: bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    /**
     * 每个桶被定义成链表LinkedList,便于插入元素
     * Collections.sort底层采用的是归并排序或Timsort,可以简单地把它们当作一种时间复杂度为O(nlogn)的排序。
     */

}
