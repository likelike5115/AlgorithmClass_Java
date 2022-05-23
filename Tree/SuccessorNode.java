package com.like.tree;

/**
 * @Description  求一个节点在二叉树中序遍历中的后继节点（这个节点后面一个）
 * @Author
 */
public class SuccessorNode {
    public static Node getSuccessorNode(Node head, Node x){
        if(head == null){
            return null;
        }
        if(x.right != null){
            return getMostLeft(x.right);//查找x右树上的最左节点
        }else{
            Node parent = x.parent;
            while(parent != null && parent.right == x){
                //包括情况2-2,parent为null即x为最右节点
                x = parent;
                parent = x.parent;
            }
            return parent;
        }
    }
    public static Node getMostLeft(Node node){
        Node cur = node;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;  //包括了情况1-2,没有左子树直接返回head.right
    }
}
