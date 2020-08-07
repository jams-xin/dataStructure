package com.itxin.domain;

/**
 * @ClassName HuffmanTreeNode
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/25 21:06
 * @Version 1.0
 **/
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
    //实现了Comparable接口，使得该类支持排序
    public int value;
    public HuffmanTreeNode left;
    public HuffmanTreeNode right;
    // 初始化
    public HuffmanTreeNode(int value){
        this.value = value;
    }
    public void preOrder(){
        // 前序遍历
        System.out.println("HuffmanTreeNode is :" + this.value);

        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }

    }

    public int getValue() {
        return value;
    }

    public HuffmanTreeNode getLeft() {
        return left;
    }

    public HuffmanTreeNode getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(HuffmanTreeNode left) {
        this.left = left;
    }

    public void setRight(HuffmanTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanTreeNode o) {
        return this.value - o.value;
    }

}
