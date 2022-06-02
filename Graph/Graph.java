package com.like.graph;

import com.like.graph.Node;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description
 * @Author
 */
public class Graph {
    public HashMap<Integer, Node> nodes; //点的编号和点集
    public HashSet<Edge> edges; //边集，储存所有的边
}
