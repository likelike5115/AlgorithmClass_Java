package com.like.tree;
import com.like.tree.CBT_And_FBT;
import java.util.*;

/**
 * @Description  二叉树的前序、中序、后序遍历
 * @Author
 */
public class recursion {
    //方法一：递归
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }
    public static void postOrderRecur(Node head){
        if(head == null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value);
    }
    //方法二：用stack或者queue做
    public static void preOrderRecur1(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value);
                if(head.right != null){
                    stack.add(head.right);
                }
                if(head.left != null){
                    stack.add(head.left);
                }
            }
        }
    }
    public static void postOrderRecur1(Node head){
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.add(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.add(head);
                if(head.left != null){
                    stack1.add(head.left);
                }
                if(head.right != null){
                    stack1.add(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.println(stack2.pop().value);
                //stack2.pop();
            }
        }

    }
    public static void inOrderRecur1(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.add(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;

                }
            }
        }
    }
    //宽度优先遍历
    public static void wideFirst(Node head){
        if(head != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while(!queue.isEmpty()){
                head = queue.poll();
                System.out.println(head.value);
                if(head.left != null){
                    queue.add(head.left);
                }
                if(head.right != null){
                    queue.add(head.right);
                }
            }
        }
    }
    //求二叉树的最大宽度
    public static int maxWide(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        queue.add(head);
        map.put(head,1);
        int curLevel = 1;
        int curLevelNode = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int levelOfCur = map.get(cur);
            if(levelOfCur == curLevel){
                curLevelNode++;
            }else{
                max = Math.max(max,curLevelNode);
                curLevel++;
                curLevelNode = 1; //为什么这里等于1

            }
            if(cur.left!= null ){
                map.put(cur.left,levelOfCur + 1); //注意为levelOfCur
                queue.add(cur.left);
            }
            if(cur.right != null){
                map.put(cur.right,levelOfCur + 1);
                queue.add(cur.right);
            }
        }
        System.out.println(max);
        max = Math.max(max,curLevelNode);//注意要做最后一层结算
        return max;
    }
    //判断一棵二叉树是否为搜索二叉树
    //方法一：先左树再右树
    public static int preValue = Integer.MIN_VALUE;
    public static boolean checkBST(Node head){
        if(head == null){
            return true;
        }
        if(preValue >= head.value){
            return false;
        }else{
            preValue = head.value;
        }
        return checkBST(head.right);
    }
    //方法二：用list记录中序遍历
    public static void checkBST2(Node head){
        List<Node> list = new ArrayList<>();
        process(head, list);
    }
    public static void process(Node head, List list){
        if(head == null){
            return;
        }
        process(head.left, list);
        list.add(head);
        process(head.right,list);
    }
    //方法三：递归套路
    public static class ReturnData{
        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }

        public boolean isBST;
        public int min;
        public int max;
    }
    public static ReturnData process(Node head){
        if(head == null){
            return null;
        }
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);
        int min = head.value;
        int max = head.value;
        if(leftData != null){
            min = Math.min(leftData.min,min);
            max = Math.max(leftData.max, max);
        }
        if(rightData != null){
            min = Math.min(rightData.min,min);
            max = Math.max(rightData.max,max);
        }
        boolean isBST = true;
        //记得检查leftData != null
        if(leftData != null && (!leftData.isBST || leftData.max >= head.value)){
            isBST = false;
        }
        if(rightData != null && (!rightData.isBST || rightData.min <= head.value) ){
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }


    public static void main(String[] args) {
        Node node4 = new Node(4, null,null);
        Node node5 = new Node(5, null,null);
        Node node6 = new Node(6, null,null);

        //Node node8 = new Node(8, null,null);
        //Node node9 = new Node(9, node8,null);
        Node node7 = new Node(7, null,null);
        Node node2 = new Node(2, node4,node5);
        Node node3 = new Node(3, node6,node7);
        Node node1 = new Node(1, node2,node3);
        //preOrderRecur(node1);
        //inOrderRecur(node1);
        //postOrderRecur(node1);
        //wideFirst(node1);
        //inOrderRecur1(node1);
        //System.out.println(maxWide(node1));
        //System.out.println(checkBST(node1));
        //System.out.println(CBT_And_FBT.checkFBT(node1));
        //CheckAVL.AVLorNot(node1);
        //System.out.println(LowestCommonAncestor236.lca2(node1, node6, node7).value);
        //System.out.println(Serialization.treeToString(node1));
        //String serialString = Serialization.treeToString(node1);
        //Node nodeHead = Serialization.stringToTree(serialString);
        //inOrderRecur(nodeHead);
    }
}
