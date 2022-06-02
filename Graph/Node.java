package com.like.graph;



import java.util.ArrayList;

/**
 * @Description
 * @Author
 */
public class Node {
    public int value; //点的值，可以是数值或字符
    public int in; //入度：有多少个点是指向这个点的
    public int out; //出度：这个点指向多少个点
    public ArrayList<Node> nexts; //从这个点发散出去的边到达的点
    public ArrayList<Edge> edges;//从这个点发散出去的所有边

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
