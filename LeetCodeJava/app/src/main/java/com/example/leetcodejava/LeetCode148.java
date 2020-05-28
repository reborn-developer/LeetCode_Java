package com.example.leetcodejava;

public class LeetCode148 {
    /**
     * 148、排序链表
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     * 示例 2:
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     */

    /**
     *  思路:
     *  题目要求排序算法的时间复杂度为 O(n log n) ，空间复杂度为 O(1) ，直接想到归并排序。
     *  归并排序 是采用分治法的一种排序算法：
     *  分，就是把数列一分二，二分四...最后分成两两一组的最小子集
     *  治，就是把分开后的子集，一一排序后归并在一起
     *  最后由局部有序成为全部有序，和数组的归并排序相比，链表多出的一步就是如何找到链表的中点？
     */

    /**
     * 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     * 合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * 双指针法合并，建立辅助ListNode h 作为头部。
     * 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * 返回辅助ListNode h 作为头部的下个节点 h.next。
     * 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     * 当题目输入的 head == None 时，直接返回None。
     *
     */


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode testCaseNode() {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        return node1;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
