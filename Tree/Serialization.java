package com.like.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 把一个二叉树序列化成字符串并返回
 * @Author
 */
public class Serialization {
    //中序遍历二叉树转化为字符串
    public static String treeToString(Node head){
        if(head == null){
            return "#_";
        }
        String leftString = treeToString(head.left);
        String curString = Integer.toString(head.value) + "_";
        String rightString = treeToString(head.right);
        return leftString + curString +rightString;
    }
    public static Node stringToTree(String serial){
        Queue<Node> queue = new LinkedList<>();
        String[] array = serial.split("_");
        for(int i = 0; i < array.length; i++){
            if(!array[i].equals("#")){
                queue.add(new Node(Integer.valueOf(array[i])));
            }else{
                queue.add(null);
            }

        }
        return createTree(queue);
    }
    public static Node createTree(Queue queue){ //中序遍历的反序列化要怎么写
        Node head = new Node();
        head.left = createTree(queue);
        if(queue.peek() == null){
            return null;
        }
        head = (Node) queue.poll();
//        if(head == null){
//            return null;
//        }
        head.right = createTree(queue);
        return head;

    }
}
