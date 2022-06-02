package com.like.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author
 */
public class BFS {
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList();
        HashSet<Node> set = new HashSet<>();//记录已经查找过的节点
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value); //所要进行的操作
            for(Node next : node.nexts){
                queue.add(next);
                set.add(next);
            }
        }
    }
}
