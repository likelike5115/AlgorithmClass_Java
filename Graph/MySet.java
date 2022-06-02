package com.like.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author
 */
public class MySet {
    HashMap<Node, List<Node>> nodeSet;

    public MySet(List<Node> nodes) {
        for(Node node : nodes){
            List<Node> set = new ArrayList<>();
            set.add(node);
            nodeSet.put(node, set);
        }
    }
    public boolean isSameSet(Node from, Node to){
        List<Node> fromSet = nodeSet.get(from);
        List<Node> toSet = nodeSet.get(to);
        return fromSet == toSet;
    }
    public void union(Node from, Node to){
        List<Node> fromSet = nodeSet.get(from);
        List<Node> toSet = nodeSet.get(to);
        for(Node node : toSet){
            fromSet.add(node);
            nodeSet.put(to,fromSet);
        }
    }
}
