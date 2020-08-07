package com.itxin.tree;

import com.itxin.domain.BinaryTreeNode;

/**
 * @ClassName BinaryTreeDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/23 11:35
 * @Version 1.0
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        System.out.println("Hello dataStructure!");
        BinaryTree binaryTree = new BinaryTree();

        //creat node
        BinaryTreeNode root = new BinaryTreeNode(1, "宋江");
        BinaryTreeNode node2 = new BinaryTreeNode(2, "吴用");
        BinaryTreeNode node3 = new BinaryTreeNode(3, "卢俊义");
        BinaryTreeNode node4 = new BinaryTreeNode(4, "林冲");
        BinaryTreeNode node5 = new BinaryTreeNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        binaryTree.setBinaryTreeNode(root);

        System.out.println("preOrderBinaryTree is : ");
        binaryTree.preOrderBinaryTree();

        System.out.println("midOrderBinaryTree is : ");
        binaryTree.midOrderBinaryTree();

        System.out.println("postOrderBinaryTree is : ");
        binaryTree.postOrderBinaryTree();

        BinaryTreeNode resNode1 = binaryTree.preOrderBinaryTreeSearch(4);
        BinaryTreeNode resNode2 = binaryTree.midOrderBinaryTreeSearch(4);
        BinaryTreeNode resNode3 = binaryTree.postOrderBinaryTreeSearch(4);

        System.out.println(resNode1);
        System.out.println(resNode2);
        System.out.println(resNode3);

        System.out.println("after delete : ");
        binaryTree.delBinaryTreeNode(4);
        binaryTree.preOrderBinaryTree();
    }
}

//creat BinaryTree
class BinaryTree{
    BinaryTreeNode binaryTreeNode;

    public void setBinaryTreeNode(BinaryTreeNode binaryTreeNode) {
        this.binaryTreeNode = binaryTreeNode;
    }

    public void delBinaryTreeNode(int num){
        if (binaryTreeNode != null){
            if (binaryTreeNode.getNum() == num){
                //first: only have a root
                binaryTreeNode = null;
            }else{
                // second
                binaryTreeNode.delNode(num);
            }
        }else{
            System.out.println("the tree is empty");
        }
    }

    public void preOrderBinaryTree(){
        if (binaryTreeNode != null){
            binaryTreeNode.preOrder();
        }else{
            System.out.println("the tree is empty");
        }
    }
    public void midOrderBinaryTree(){
        if (binaryTreeNode != null){
            binaryTreeNode.midOrder();
        }else{
            System.out.println("the tree is empty");
        }
    }
    public void postOrderBinaryTree(){
        if (binaryTreeNode != null){
            binaryTreeNode.postOrder();
        }else{
            System.out.println("the tree is empty");
        }
    }

    public BinaryTreeNode preOrderBinaryTreeSearch(int num){
        if (binaryTreeNode != null){
            return binaryTreeNode.preOrderSearch(num);
        }else{
            System.out.println("the tree is empty");
            return null;
        }
    }
    public BinaryTreeNode midOrderBinaryTreeSearch(int num){
        if (binaryTreeNode != null){
            return binaryTreeNode.midOrderSearch(num);
        }else{
            System.out.println("the tree is empty");
            return null;
        }
    }
    public BinaryTreeNode postOrderBinaryTreeSearch(int num){
        if (binaryTreeNode != null){
            return binaryTreeNode.postOrderSearch(num);
        }else{
            System.out.println("the tree is empty");
            return null;
        }
    }
}

