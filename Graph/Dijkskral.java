package com.like.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author
 */
public class Dijkskral {
    public static HashMap<Node, Integer> dikstral(Node head){
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        HashSet<Node> selectedNode = new HashSet<>();
        nodeMap.put(head, 0);
        Node minNode = minimumButNotSelected(nodeMap,selectedNode);
        while(minNode != null){
           for(Edge edge : minNode.edges){
               if(!nodeMap.containsKey(edge.to)){ //不是查这个!selectedNode.contains(edge.to)
                   nodeMap.put(edge.to, nodeMap.get(minNode) + edge.weight);
               }
               nodeMap.put(edge.to, Math.min(nodeMap.get(edge.to), nodeMap.get(minNode) + edge.weight));
           }
           selectedNode.add(minNode); //漏写
           minNode = minimumButNotSelected(nodeMap,selectedNode); //漏写
        }
        return nodeMap;

    }
    public static Node minimumButNotSelected(HashMap<Node, Integer> nodeMap, HashSet<Node> selectedNode){
        int min = Integer.MAX_VALUE;
        Node result =null;
        for(Map.Entry<Node,Integer> entry : nodeMap.entrySet()){
            if(!selectedNode.contains(entry.getKey()) && entry.getValue() < min){
                min = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
