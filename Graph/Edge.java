package com.like.graph;

/**
 * @Description 表示有向边
 * 有向边：两条方向相反的有向边拼起来
 * @Author
 */
public class Edge {
    public int weight;//边的权重
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
