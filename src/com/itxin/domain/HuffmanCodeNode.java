package com.itxin.domain;

/**
 * @ClassName HuffmanCodeNode
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/26 16:01
 * @Version 1.0
 **/
public class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    //实现了Comparable接口，使得该类支持排序
    public Byte value;
    public int weight;
    public HuffmanCodeNode left;
    public HuffmanCodeNode right;
    // 初始化
    public HuffmanCodeNode(Byte value, int weight){
        this.value = value;
        this.weight =weight;
    }

    public void preOrder(){
        // 前序遍历
        System.out.println("HuffmanCodeNode is :" + this.value);

        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }

    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;
    }
}
