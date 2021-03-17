package com.example.leetcodejava.DataStructure.LinkedList;

import java.util.List;

/**
 *  链表反转
 *
 *  https://www.bilibili.com/video/BV1U7411A75v?from=search&seid=12945364916692218894
 */
public class ReverseLinkedList {

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        newHead.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 非递归
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;

            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return  newHead;
    }
}


