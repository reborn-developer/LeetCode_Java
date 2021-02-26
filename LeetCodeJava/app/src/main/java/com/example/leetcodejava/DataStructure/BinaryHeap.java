package com.example.leetcodejava.DataStructure;

/**
 * 二叉堆，分为最大堆和最小堆, 是一种特殊的完全二叉树
 *
 * 最大堆的任何一个父节点的值，都大于或等于 它 左、右孩子节点的值。
 * 最小堆的任何一个父节点的值，都小于或等于它左、 右孩子节点的值。
 *
 * 二叉堆有如下操作
 * 1、插入节点 (上浮)
 * 2、删除节点 （下沉)
 * 3、构建二叉堆 （下沉-----所有的非叶子节点下沉，从最后一个非叶子节点开始)
 *
 * 若父节点下标为parent，则左孩子下标2*parent+1， 右孩子下标2*parent+2
 * 反过来，若一个左孩子节点的下标为leftChild，那么它的父节点下标（leftChild-1)/2
 *
 *  注意： 二叉堆虽然是一个完全二叉树，但它的存储方式并不是链式存储，而是顺序存储。换句话说，二叉堆的所有节点都存储在数组中。
 *
 *  以下代码以最小堆为例
 */
public class BinaryHeap {

    /**
     * "上浮"调整
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;

        // temp保存插的叶子节点值，用于最后的赋值
        int temp = array[childIndex];

        while (childIndex > 0 && temp < array[parentIndex]) {
            // 无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2; //上浮的意义 继续往上操作，找父节点的父节点
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     * @param array 待调整的堆
     * @param parentIndex 要“下沉”的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex+1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，则直接跳出
            if (temp < array[childIndex])
                break;
            // 无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;  // 下沉的意义- 继续往下走 找它的孩子
        }
        array[parentIndex] = temp;
    }

    /**
     *  构建堆
     *  @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做“下沉”操作
        for (int i = (array.length-2)/2; i>=0; i--) {
            downAdjust(array, i, array.length);
        }
    }

}
