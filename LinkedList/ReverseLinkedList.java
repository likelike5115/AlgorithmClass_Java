package com.like.linkedlist;

/**
 * @Description 反转链表的两种实现方法：迭代和递归
 * @Author
 */
public class ReverseLinkedList {
    public static ListNode iterate(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
//            prev = curr;
//            curr = curr.next;
//            curr.next = prev;
            ListNode next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;
    }
    public static ListNode recursion(ListNode head){
       if(head == null || head.next == null){
           return head;
       }
       ListNode newHead = recursion(head.next);
       head.next.next = head;
       head.next = null;
       return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        //ListNode headNew = iterate(node1);
        ListNode headNew = recursion(node1);
        System.out.println(headNew.toString());
    }
}
