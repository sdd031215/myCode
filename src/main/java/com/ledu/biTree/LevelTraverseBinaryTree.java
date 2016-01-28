package com.ledu.biTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelTraverseBinaryTree {

    /**
     * 参考：http://bylijinnan.iteye.com/blog/1629457
     * 编程之美 分层遍历二叉树
     * 之前已经用队列实现过二叉树的层次遍历，但这次要求输出换行，因此要标记什么时候要换行：
     * 用inCount记录某层有多少个元素，outCount记录当前输出了多少个元素；当inCount==outCount时，就说明某层元素已经完全输出，此时应该换行(outCount清零)
     * 此外，观察发现，当第K层元素全部出队（并已将各自左右孩子入队）后，队列里面刚好存放了第K+1层的所有元素，不多不少，所以有：inCount = queue.size();
     * 
     * 书上的扩展问题也很有意思（从下往上分层输出），既然是反过来输出，第一反应是利用栈
     * 但同时又要记录何时换行（每行有多少个元素），只好用ArrayList模拟一个“伪栈”：
     * 1、第一步操作和“从上往下分层输出”是类似的：从root开始遍历，并将所有元素放入“队列”（ArrayList），用-1表示一层的结束
     * 2、输出。不是从队头开始，而是从队尾开始，依次输出
     * 分析到这里，这里面的ArrayList定义为“双向队列”更合适
     */
    public static void main(String[] args) {
        /*
                            __1__
                           /     \
                        __2__     3__
                       /     \       \
                      4     __5__     6
                           7     8
         */
        int[] src = { 1, 2, 3, 4, 5, 0, 6, 0, 0, 7, 8 };
        LevelTraverseBinaryTree data = new LevelTraverseBinaryTree();
        Node root = data.createTree(src);
        data.traverseByLevelFromTop(root);
        System.out.println();
        data.traverseByLevelFromBottom(root);
    }
    
    /*
     从上往下分层输出
        1 
        2 3 
        4 5 6 
        7 8 
     */
    public void traverseByLevelFromTop(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(node);
        int inCount = 1;
        int outCount = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.pollFirst();
            System.out.print(curNode.getData() + " ");
            outCount++;
            if (curNode.getLeft() != null) {
                queue.addLast(curNode.getLeft());
            }
            if (curNode.getRight() != null) {
                queue.addLast(curNode.getRight());
            }
            if (outCount == inCount) {
                System.out.println();
                inCount = queue.size();
                outCount = 0;
            }
        }
    }
    
    /*
    从下往上分层输出
        7 8 
        4 5 6 
        2 3 
        1 
    */
    public void traverseByLevelFromBottom(Node node) {
        if (node == null) {
            return;
        }
        List<Node> list = new ArrayList<Node>();
        list.add(node);
        list.add(new Node(-1));     //-1表示一层结束，打印时要换行
        int i = 0;
        int size = list.size();
        while (i < size) {
            Node curNode = list.get(i);
            
            /*交换下面这两个操作，可实现输出：
                8 7 
                6 5 4 
                3 2 
                1
             */
            if (curNode.getRight() != null) {
                list.add(curNode.getRight());
            } 
            if (curNode.getLeft() != null) {
                list.add(curNode.getLeft());
            }
            
            i++;
            if (i == size) {
                if (curNode.getData() != -1 && curNode.getLeft() == null && curNode.getRight() == null) {   //已经遍历到最底层的最后一个元素，结束循环
                    break;
                }
                size = list.size();
                list.add(new Node(-1));     
            }
        }
        
        //从后往前遍历，相当于“栈”
        for (size = list.size(), i = size - 1; i >=0; i--) {
            int val = list.get(i).getData();
            if (val == -1) {
                System.out.println();
            } else {
                System.out.print(val + " ");
            }
        }
    }
    

    public Node createTree(int[] data){  
        List<Node> nodeList=new ArrayList<Node>();  
        for(int each:data){  
            Node n=new Node(each);  
            nodeList.add(n);  
        }  
        int lastRootIndex=data.length/2-1;  
        for(int i=0;i<=lastRootIndex;i++){  
            Node root=nodeList.get(i);  
            Node left=nodeList.get(i*2+1);  
            if(left.getData()!=0){  
                root.setLeft(left);  
            }else{  
                root.setLeft(null);  
            }  
            if(i*2+2<data.length){  
                Node right=nodeList.get(i*2+2);  
                if(right.getData()!=0){  
                    root.setRight(right);  
                }else{  
                    root.setRight(null);  
                }  
            }  
              
        }  
        Node root=nodeList.get(0);  
        return root;  
    }  
}

class Node {
    
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
