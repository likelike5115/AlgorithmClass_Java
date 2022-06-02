package com.like.graph;

import java.util.*;

/**
 * @Description
 * @Author
 */
public class Prim {
    public static List<Edge> prim(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        HashSet<Node> nodeSet = new HashSet<>();
        List<Edge> result = new ArrayList<>();
        for(Node node : graph.nodes.values()){
            if(!nodeSet.contains(node)){
                nodeSet.add(node);
                for(Edge edge : node.edges){
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge cur = priorityQueue.poll();
                    Node toNode = cur.to;
                    if(!nodeSet.contains(toNode)){
                        nodeSet.add(toNode);
                        result.add(cur);
                        for(Edge edge: toNode.edges){
                            priorityQueue.add(edge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
