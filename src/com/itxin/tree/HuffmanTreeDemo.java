package com.itxin.tree;

import com.itxin.domain.HuffmanTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanTreeDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/25 20:07
 * @Version 1.0
 **/
public class HuffmanTreeDemo {
    public static void main(String[] args){
        System.out.println("Hello dataStructure! I am HuffmanTreeDemo");
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTreeNode root = createHuffmanTree(arr);
        preOrderHuffmanTreeSearch(root);

    }

    public static void preOrderHuffmanTreeSearch(HuffmanTreeNode root){
        /**
         * @param HuffmanTreeNode root
         * @return no
         * @description 前序遍历赫夫曼树
         */
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("HuffmanTree is empty");
        }
    }

    public static HuffmanTreeNode createHuffmanTree(int[] arr){
        /**
         * @param int[] arr
         * @return HuffmanTreeNode
         * @description 构建赫夫曼树
         */
        // 构造节点列表
        List<HuffmanTreeNode> huffmanTreeNodes = new ArrayList<>();
        for (int value : arr){
            huffmanTreeNodes.add(new HuffmanTreeNode(value));
        }

        while (huffmanTreeNodes.size() > 1){
            //first 从小到大进行排序
            Collections.sort(huffmanTreeNodes);

            //second 取出根节点权值最小的两颗二叉树
            HuffmanTreeNode leftNode = huffmanTreeNodes.get(0);
            HuffmanTreeNode rightNode = huffmanTreeNodes.get(1);

            //third 添加根节点，组成新的二叉树
            HuffmanTreeNode parent = new HuffmanTreeNode(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //forth 去除旧值，添加父节点
            huffmanTreeNodes.remove(leftNode);
            huffmanTreeNodes.remove(rightNode);
            huffmanTreeNodes.add(parent);

        }

        //fifth 返回根节点
        return huffmanTreeNodes.get(0);
    }
}
