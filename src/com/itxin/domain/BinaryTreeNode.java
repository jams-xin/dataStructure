package com.itxin.domain;

/**
 * @ClassName BinaryTreeNode
 * @Description creat BinaryTreeNode
 * @Author Yuan Yunxin
 * @Data 2020/7/25 21:22
 * @Version 1.0
 **/
public class BinaryTreeNode {
    public int num;
    public String name;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int num,String name){
        this.num = num;
        this.name = name;
    }


    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }


    public void delNode(int num){
        /**
         * @param int num
         * @return no
         * @description 删除节点
         */
        // first
        if (this.left != null && this.left.num == num){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.num == num){
            this.right = null;
            return;
        }

        // second
        if (this.left != null){
            this.left.delNode(num);
        }

        if (this.right != null){
            this.right.delNode(num);
        }
    }
    public void preOrder(){
        /**
         * @param no
         * @return no
         * @description 前序遍历
         */
        System.out.println(this);  //this 代表当前对象 BinaryTreeNode
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void midOrder(){
        /**
         * @param no
         * @return no
         * @description 中序遍历
         */
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);  //this 代表当前对象 BinaryTreeNode
        if (this.right != null){
            this.right.midOrder();
        }
    }

    public void postOrder(){
        /**
         * @param no
         * @return no
         * @description 后序遍历
         */
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);  //this 代表当前对象 BinaryTreeNode
    }

    public BinaryTreeNode preOrderSearch(int num){
        /**
         * @param int num
         * @return BinaryTreeNode
         * @description 前序遍历查找
         */

        // first
        System.out.println("preOrderSearch begin*********");
        if (this.num == num){
            return this;
        }
        //second
        BinaryTreeNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(num);
        }
        if (resNode != null){
            return resNode;
        }
        // third
        if (this.right != null){
            resNode = this.right.preOrderSearch(num);
        }
        return resNode;
    }

    public BinaryTreeNode midOrderSearch(int num){
        /**
         * @param int num
         * @return BinaryTreeNode
         * @description 中序遍历查找
         */
        // first
        BinaryTreeNode resNode = null;
        if (this.left != null){
            resNode = this.left.midOrderSearch(num);
        }
        if (resNode != null){
            return resNode;
        }
        // second
        System.out.println("midOrderSearch begin*********");
        if (this.num == num){
            return this;
        }
        // third
        if (this.right != null){
            resNode = this.right.midOrderSearch(num);
        }
        return resNode;
    }

    public BinaryTreeNode postOrderSearch(int num){
        /**
         * @param int num
         * @return BinaryTreeNode
         * @description 后序遍历查找
         */

        // first
        BinaryTreeNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(num);
        }
        if (resNode != null){
            return resNode;
        }
        // second
        if (this.right != null){
            resNode = this.right.postOrderSearch(num);
        }

        // third
        System.out.println("postOrderSearch begin*********");
        if (this.num == num){
            return this;
        }
        return resNode;
    }
}
