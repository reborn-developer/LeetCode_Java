package com.example.leetcodejava.DataStructure.LinkedList;

/**
 *  链表相关操作
 */
public class MyLinkedList {

    // 头节点指针
    private ListNode head;

    // 尾节点指针
    private ListNode last;

    // 链表实际长度
    private int size;

    /**
     *  链表插入元素
     *  @param data 插入元素
     *  @param index 插入位置
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("超出链表节点范围");
        }

        ListNode insertedNode = new ListNode(data);
        if (size == 0) {
            // 空链表
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            // 插入头部
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {
            // 插入尾部
            last.next = insertedNode;
            last = insertedNode;
        } else {
            // 插入中间
            ListNode prevNode = get(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     * @param index 删除的位置
     */
    public ListNode remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("超出链表节点范围");
        }
        ListNode removedNode = null;
        if (index == 0) {
            // 删除头节点
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            ListNode prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            // 删除中间节点
            ListNode prevNode = get(index-1);
            ListNode nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * 链表查找元素
     * @param index 查找的位置
     */
    public ListNode get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("超出链表节点范围");
        }
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // 以上是对单链表相关操作的代码实现。为了尾部插入的方便，代码中额 外增加了指向链表尾节点的指针last。
}
