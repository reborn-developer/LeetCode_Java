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
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while (head!=null){
            if (curr.next==null||curr.next.val>head.val){
                ListNode p=head.next;
                head.next=curr.next;
                curr.next=head;
                curr=dummy;
                head=p;
            }
            else{
                curr=curr.next;
            }
        }
        return dummy.next;
    }

}
