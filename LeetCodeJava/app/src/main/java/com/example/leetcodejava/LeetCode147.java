package com.example.leetcodejava;

import java.util.List;

public class LeetCode147 {
    /**
     * LeetCode147. 对链表进行插入排序
     *
     * 对链表进行插入排序。
     *
     * 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
     * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
     *
     * 插入排序算法：
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     *
     * 示例 1：
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     * 示例 2：
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
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

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 创建带头结点赋初值
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 如果是升序，则遍历下一个(head后面的)
            if (end.val < cur.val) {
                end.next = cur;
                end = cur;
                cur = cur.next;
            } else {
                // 先定义一个 tmp 指向 cur 下一个结点防止丢链
                ListNode tmp = cur.next;
                // 断开要排的元素
                end.next = tmp;
                // 从头判断找出合适的插入位置
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                // 找到插入位置后直接将元素放进来
                cur.next = pre.next;// 先链接后面
                pre.next = cur;     //再链接前面
                // 随后将定位指针归位
                pre = dummy;
                cur = tmp;
            }
        }
        return dummy.next;
    }
}
