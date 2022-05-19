package com.like.linkedlist;

/**
 * @Description 回文链表 快慢指针解法找到链表中点，反转前半部分链表指针，逐个比较
 * @Author
 */


public class PalindromeLinkedList234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }//漏写边界条件
        ListNode fast = head, slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
            //fast = fast.next.next; 放在此处报NullPointerException
        }
        //不明白
        //  当链表长度为偶数时，fast最终必不为 null
        //  当链表长度为奇数时，当fast.next为null时，fast必为null
        if(fast != null){
            slow = slow.next;
        }
        while(pre != null && slow != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode node5 = new ListNode(1,null);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        boolean result = isPalindrome(node1);
        System.out.println(result);
    }
}
