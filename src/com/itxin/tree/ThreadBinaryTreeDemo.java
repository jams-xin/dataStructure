package com.itxin.tree;

import com.itxin.domain.ThreadBinaryTreeNode;

/**
 * @ClassName ThreadBinaryTreeDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/24 12:04
 * @Version 1.0
 **/
public class ThreadBinaryTreeDemo {
    public static void main(String[] args){
        System.out.println("Hello dataStructure! I am ThreadBinaryTreeDemo");
        //测试一把中序线索二叉树的功能
        ThreadBinaryTreeNode root = new ThreadBinaryTreeNode(1, "tom");
        ThreadBinaryTreeNode node2 = new ThreadBinaryTreeNode(3, "jack");
        ThreadBinaryTreeNode node3 = new ThreadBinaryTreeNode(6, "smith");
        ThreadBinaryTreeNode node4 = new ThreadBinaryTreeNode(8, "mary");
        ThreadBinaryTreeNode node5 = new ThreadBinaryTreeNode(10, "king");
        ThreadBinaryTreeNode node6 = new ThreadBinaryTreeNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setThreadBinaryTreeNode(root);
        threadBinaryTree.threadNodeSearch();
        System.out.println("ThreadBinaryTreeNode is behgining**************");
        ThreadBinaryTreeNode leftNode = node5.getLeft();
        System.out.println(leftNode);
        System.out.println("ThreadBinaryTreeTraverse is begining**************");
        threadBinaryTree.ThreadBinaryTreeTraverse();
    }
}

// creat ThreadBinaryTree
class ThreadBinaryTree{
    ThreadBinaryTreeNode threadBinaryTreeNode;
    private ThreadBinaryTreeNode pre = null;

    public void setThreadBinaryTreeNode(ThreadBinaryTreeNode threadBinaryTreeNode) {
        this.threadBinaryTreeNode = threadBinaryTreeNode;
    }
    // 重载threadNodeSearch
    public void threadNodeSearch(){
        this.threadNodeSearch(threadBinaryTreeNode);
    }
    // 重载ThreadBinaryTreeTraverse
    public void ThreadBinaryTreeTraverse(){
        this.ThreadBinaryTreeTraverse(threadBinaryTreeNode);
    }

    public  void ThreadBinaryTreeTraverse(ThreadBinaryTreeNode node){
        /**
         * @param ThreadBinaryTreeNode node
         * @return no
         * @description 中序线索遍历方法，效率比递归高
         */
        while (node != null){
            // first
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }
            // second
            System.out.println(node);

            // third
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
    public void threadNodeSearch(ThreadBinaryTreeNode node){
        /**
         * @param ThreadBinaryTreeNode node
         * @return no
         * @description 中序搜索节点
         */
        if (node == null){
            return;
        }
        //first
        threadNodeSearch(node.left);
        //second
        // 1.0处理当前节点（前驱）
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // 2.0处理后继节点
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        // 3.0
        pre = node;

        //third
        threadNodeSearch(node.getRight());
    }
}
