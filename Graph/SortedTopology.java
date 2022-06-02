package com.like.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 拓扑排序
 * @Author
 */
public class SortedTopology {
    public static ArrayList<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();//记录每个节点的入度
        Queue<Node> zeroQueue = new LinkedList<>(); //存储入度in为0的Node
        for(Node node : graph.nodes.values()){ //返回hashmap values的集合
            inMap.put(node, node.in);
            if(node.in == 0){      //遍历存储node的hashmap得到入度为0的第一个点
                zeroQueue.add(node);
            }
        }
        ArrayList<Node> result = new ArrayList<>();
        while(!zeroQueue.isEmpty()){
            Node cur = zeroQueue.poll(); //把入度为0的节点移除，
            // 把它加入result，并且把与它相邻的点的入度都-1
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroQueue.add(next);
                }
            }


        }
        return result;
    }
}
