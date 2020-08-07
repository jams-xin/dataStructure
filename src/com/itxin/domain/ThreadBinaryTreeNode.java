package com.itxin.domain;

/**
 * @ClassName ThreadBinaryTreeNode
 * @Description creat ThreadBinaryTreeNode
 * @Author Yuan Yunxin
 * @Data 2020/7/25 21:17
 * @Version 1.0
 **/
public class ThreadBinaryTreeNode {
    public int num;
    public String name;
    public ThreadBinaryTreeNode left;
    public ThreadBinaryTreeNode right;
    private int leftType;
    private int rightType;
    public ThreadBinaryTreeNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getLeftType() { return leftType; }

    public int getRightType() { return rightType; }

    public void setLeftType(int leftType) { this.leftType = leftType; }

    public void setRightType(int rightType) { this.rightType = rightType; }

    public void setNum(int num) { this.num = num; }

    public void setName(String name) { this.name = name; }

    public void setLeft(ThreadBinaryTreeNode left) { this.left = left; }

    public void setRight(ThreadBinaryTreeNode right) { this.right = right; }

    public int getNum() { return num; }

    public String getName() { return name; }

    public ThreadBinaryTreeNode getLeft() { return left; }

    public ThreadBinaryTreeNode getRight() { return right; }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
