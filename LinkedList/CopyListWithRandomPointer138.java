package com.like.linkedlist;


import org.w3c.dom.NodeList;

import java.util.HashMap;

/**
 * @Description
 * @Author
 */
public class CopyListWithRandomPointer138 {
    //方法一：使用HashMap,会占用额外内存空间
    public static ListNode copyList(ListNode head){
//        if(head == null){
//            return null;
//        }
//        由于return temp.get(head); head是null return结果也会是null,所以没必要写
        HashMap<ListNode, ListNode> temp = new HashMap<>();
        ListNode cur = head;
        while(cur != null){
            temp.put(cur, new ListNode(cur.val));
            //在HashMap的value中是新建node,我错写为temp.put(cur,cur)结果报引用自己的错误
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            temp.get(cur).random = cur.random == null ? null : temp.get(cur.random);
            //这里没必要判断random是不是null，直接复制就好
            temp.get(cur).next = temp.get(cur.next);
            cur = cur.next;
        }
//        ListNode newHead = temp.get(head);
//        cur = head;
//        ListNode newCur = newHead;
//        while(cur != null){
//            newCur = temp.get(cur);
//            cur = cur.next;
//            newCur = newCur.next;
//        }
//        return newHead;
        //没必要再遍历一次，直接：
        return temp.get(head);
    }
    //方法二：把新复制链表的每个节点接在老链表后面
    public static ListNode copyList2(ListNode head){
        if(head == null){
            return null;
        }//head 为null时不会复制，考虑边界条件
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next= cur.next;
            //ListNode temp = cur;
            cur.next = new ListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while(cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;

        }
        cur = head;
        ListNode curCopy = null;
        ListNode res = head.next;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = next == null ? null : next.next;
            cur.next = next;
            cur = next;


        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode result = copyList(head);
        System.out.println(result);
    }
}
