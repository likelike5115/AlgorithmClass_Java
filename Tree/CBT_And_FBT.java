package com.like.tree;

import java.util.LinkedList;

/**
 * @Description 判断一棵树是否为完全二叉树（Complete Binary Tree)
 * 于判断一棵树是否为满二叉树（Full Binary Tree)
 * @Author
 */
public class CBT_And_FBT {
    public static boolean checkCBT(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        boolean checkLeaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            left = head.left;
            right = head.right;
            if( (checkLeaf && (left != null || right != null)) ||
                    (right != null && left == null)
            ){
                return false;
            }
            if(left != null){
                queue.add(left);
            }
            if(right != null){
                queue.add(right);
            }
            if(left == null || right == null){
                checkLeaf = true;
            }

        }
        return true;
    }
    //判断满二叉树
    public static class FullData{
        int height;
        int nodes;

        public FullData(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }
    public static boolean checkFBT(Node head){
        if(head == null){
            return true;
        }
        FullData check = process(head);
        return ((1 << check.height) - 1 == check.nodes) ? true : false;
    }
    public static FullData process(Node head){
        if(head == null){
            return new FullData(0,0);
        }
        FullData left = process(head.left);
        FullData right = process(head.right);
        int height = Math.max(left.height,right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;
        return new FullData(height,nodes);
    }

}
