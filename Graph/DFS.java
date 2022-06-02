package com.like.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Description  图的深度优先遍历
 * @Author
 */
public class DFS {
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack();
        HashSet<Node> set = new HashSet();
        stack.add(node);
        set.add(node);//漏写
        System.out.println(node.value);//漏写
        while(!stack.isEmpty()){
            Node cur = stack.pop();
//            set.add(cur);
            for(Node next : node.nexts){
                if(!set.contains(next)){
                    stack.add(cur);
                    stack.add(next);
                    set.add(next);//注意是在这里将next加进set
                    System.out.println(next.value);//为什么是next?
                    break;
                }
            }
        }
    }
}
