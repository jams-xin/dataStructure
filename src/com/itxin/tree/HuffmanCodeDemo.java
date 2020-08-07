package com.itxin.tree;

import com.itxin.domain.HuffmanCodeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanCodeDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/26 16:01
 * @Version 1.0
 **/
public class HuffmanCodeDemo {
    public static void main(String[] args){
        System.out.println("Hello dataStructure! I am HuffmanCodeDemo");
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

    }

    public static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> huffmanCodeNodes){
        /**
         * @param List<HuffmanCodeNode> huffmanCodeNodes
         * @return HuffmanCodeNode
         * @description 构建赫夫曼树
         */
        while (huffmanCodeNodes.size() > 1){
            //first 从小到大进行排序
            Collections.sort(huffmanCodeNodes);

            //second 取出根节点权值最小的两颗二叉树
            HuffmanCodeNode leftNode = huffmanCodeNodes.get(0);
            HuffmanCodeNode rightNode = huffmanCodeNodes.get(1);

            //third 添加根节点，组成新的二叉树
            HuffmanCodeNode parent = new HuffmanCodeNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //forth 去除旧值，添加父节点
            huffmanCodeNodes.remove(leftNode);
            huffmanCodeNodes.remove(rightNode);
            huffmanCodeNodes.add(parent);

        }

        //fifth 返回根节点
        return huffmanCodeNodes.get(0);
    }
}
