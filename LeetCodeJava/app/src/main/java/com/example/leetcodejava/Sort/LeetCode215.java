package com.example.leetcodejava.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class LeetCode215 {
    /**
     *  LeetCode215. 数组中的第K个最大元素
     *
     *  在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     *  示例 1:
     *
     *  输入: [3,2,1,5,6,4] 和 k = 2
     *  输出: 5
     *
     *  示例 2:
     *
     *  输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     *  输出: 4
     *
     *  说明:
     *
     *  你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */

    /**
     * 方法一:排序
     * 时间复杂度 O(NlogN)，空间复杂度 O(1)
     */
    public int findKtheLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**********************************************方法二*****************************************************************/
    /**
     * 方法二、堆排序
     * 我们也可以使用堆排序来解决这个问题——建立一个大根堆，做 k−1 次删除操作后堆顶元素就是我们要找的答案
     */
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

/**********************************************方法三*****************************************************************/

/**
 * 方法三、优先队列
 * 假设数组有 len 个元素。
 * 思路：把 len 个元素都放入一个最大堆中，然后再 pop() 出 k - 1 个元素，
 * 因为前 k - 1 大的元素都被弹出了，此时最大堆的堆顶元素就是数组中的第 k 个最大元素。
 */

public int findKthLargest3(int[] nums, int k) {
    int len = nums.length;
    // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    for (int i = 0; i < len; i++) {
        maxHeap.add(nums[i]);
    }
    for (int i = 0; i < k - 1; i++) {
        maxHeap.poll();
    }
    //Java中的java.util.PriorityQueue.peek()方法用于检索或获取Queue的第一个元素或Queue头部的元素。
    // 检索到的元素不会从队列中删除或删除。
    return maxHeap.peek();
}

/***************************************************************************************************************/

/**********************************************方法四*****************************************************************/
    /**
     * 方法四、基于快速排序的选择方法
     * 时间复杂度 O(N)，空间复杂度 O(1)
     */

    Random random = new Random();

    public int findKtheLargest4(int[] nums, int k) {

        int index = nums.length - k;

        return quickSelect(nums, 0, nums.length - 1, index);
    }

    /**
     * 首先我们来回顾一下快速排序，这是一个典型的分治算法。我们对数组a[l⋯r] 做快速排序的过程是（参考《算法导论》）：
     *
     * 分解： 将数组 a[l⋯r] 「划分」成两个子数组a[l⋯q−1]、a[q+1⋯r]，使得 a[l⋯q−1] 中的每个元素小于等于a[q]，且a[q] 小于等于]a[q+1⋯r] 中的每个元素。其中，计算下标 q 也是「划分」过程的一部分。
     * 解决： 通过递归调用快速排序，对子数组 a[l⋯q−1] a[q+1⋯r] 进行排序。
     * 合并： 因为子数组都是原址排序的，所以不需要进行合并操作，a[l⋯r] 已经有序。
     * 上文中提到的 「划分」 过程是：从子数组 a[l⋯r] 中选择任意一个元素 x 作为主元，调整子数组的元素使得左边的元素都小于等于它，右边的元素都大于等于它， xx的最终位置就是 q。
     * 由此可以发现每次经过「划分」操作后，我们一定可以确定一个元素的最终位置，即 x的最终位置为 q，并且保证a[l⋯q−1] 中的每个元素小于等于a[q]，且a[q] 小于等于a[q+1⋯r] 中的每个元素。
     * 所以只要某次划分的 q为倒数第 k个下标的时候，我们就已经找到了答案。 我们只关心这一点，至于a[l⋯q−1] 和 a[q+1⋯r] 是否是有序的，我们不关心。
     *
     * 借鉴快速排序的分治思想
     * 因此我们可以改进快速排序算法来解决这个问题：在分解的过程当中，我们会对子数组进行划分，如果划分得到的 q 正好就是我们需要的下标，
     * 就直接返回 a[q]；否则，如果 qq 比目标下标小，就递归右子区间，否则递归左子区间。
     * 这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。
     */
    public int quickSelect(int[] a, int left, int right, int index) {
        int partition = randomPartition(a, left, right);

        if (partition == index) {
            return a[partition];
        } else  {
            return partition < index ? quickSelect(a, partition + 1, right, index) : quickSelect(a, left, partition - 1, index);
        }
    }

    /**
     *  为了应对极端测试用例，使得递归树加深，可以在循环一开始的时候，随机交换元素；
     *  随机化切分元素
     */
    public int randomPartition(int[]a, int left, int right) {

        int i = random.nextInt(right - left + 1) + left;

        change(a, i, right);

        return partition(a, left, right);
    }

    public void change(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 将数组的某一段元素进行划分，小的在左边，大的在右边
     */
    public static int partition(int[] a, int start, int end){
        //每次都以最右边的元素作为基准值
        int base = a[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环。
        while(start < end){
            while(start < end && a[start] <= base)
                //从左边开始遍历，如果比基准值小，就继续向右走
                start++;
            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;

                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                end--;
            }
            while(start < end && a[end] >= base)
                //从右边开始遍历，如果比基准值大，就继续向左走
                end--;
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if(start < end){
                //交换
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;

                //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                start++;
            }
        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }
}
/***************************************************************************************************************/

