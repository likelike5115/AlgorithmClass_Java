package com.like.tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description  找到一颗二叉树中两个节点的最近公共祖先
 * @Author
 */
public class LowestCommonAncestor236 {
    //解法：找出这两个节点往上的所有父节点，路径重合的第一个节点就是最近公共祖先
    //前提：node1 和 node2一定属于head为头的数
    public static Node lca(Node head, Node node1, Node node2){
        //记录任何一个节点的父节点
        HashMap<Node,Node> fatherMap = new HashMap<>();
        process(head, fatherMap);
        fatherMap.put(head, head);
        HashSet<Node> set = new HashSet<>();
        Node cur = node1;
        while(cur != head){
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(head);//这里要加上head
        Node cur2 = node2;
        while(cur2 != head){
            if(set.contains(cur2)){
                return cur2;
            }
            cur2 = fatherMap.get(cur2);
        }
        return head;
    }
    //计算维护这个HashMap
    public static void process(Node head, HashMap fatherMap){
        if(head == null){
            return; //这里是递归终止条件
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right,head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    //方法二：
    // 情况一：node1是node2的最低公共祖先或node2是node1的最低公共祖先
    //情况二：node1和node2不互为最低公共祖先，往上汇聚才能找到
    public static Node lca2(Node head, Node node1, Node node2){
        if(head == null || head == node1 || head == node2){
            return head;
        }
        Node leftReturn = lca2(head.left, node1, node2);
        Node rightReturn = lca2(head.right,node1,node2);
        if(leftReturn != null && rightReturn != null){
            return head;
        }
        return (leftReturn != null) ? leftReturn : rightReturn;
    }

}
