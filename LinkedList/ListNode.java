package com.like.linkedlist;

/**
 * @Description
 * @Author
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode random;
    ListNode(){};

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
