package com.like.tree;

/**
 * @Description 判断二叉树是否为平衡二叉树（Self-Balancing Binary Search Tree)
 * @Author
 */
public class CheckAVL {
 public static void AVLorNot(Node head){

     System.out.println(process(head).isAVL);

 }
 public static class ReturnData{
     int height;
     boolean isAVL;

     public ReturnData(int height, boolean isAVL) {
         this.height = height;
         this.isAVL = isAVL;
     }
 }
 public static ReturnData process(Node head){
     if(head == null){
         return new ReturnData(0, true);
     }
     ReturnData leftData = process(head.left);
     ReturnData rightData = process(head.right);
     int height = Math.max(leftData.height, rightData.height) + 1;
     boolean isAVL = (leftData.isAVL && rightData.isAVL && Math.abs(leftData.height - rightData.height) < 2) ? true : false;
     return new ReturnData(height,isAVL);
 }
}
