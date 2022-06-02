package com.like.graph;

import java.util.*;

/**
 * @Description
 * @Author
 */
public class Kruskal {
    public static Set<Edge> kruskal(Graph graph){
        List<Node> values = (List<Node>) graph.nodes.values();
        MySet myset = new MySet(values);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        HashSet<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge cur = priorityQueue.poll();
            Node from = cur.from;
            Node to = cur.to;
            if(!myset.isSameSet(from, to)){
                result.add(cur);
                myset.union(from, to);
            }
        }

    return result;
    }
}
