package com.itxin.tree;

/**
 * @ClassName ArrBinaryTreeDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/23 21:22
 * @Version 1.0
 **/
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        System.out.println("Hello dataStructure I am ArrBinaryTreeDemo!");
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("preOrder is begining");
        arrBinaryTree.preOrder();
        System.out.println("midOrder is begining");
        arrBinaryTree.midOrder();
        System.out.println("postOrder is begining");
        arrBinaryTree.postOrder();

    }
}

class ArrBinaryTree{
    int[] arr;
//    private ArrayList preList = new ArrayList();
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    //方法重载，设置index初始值为0
    public void preOrder(){
        preOrder(0);
    }
    public void midOrder(){
        midOrder(0);
    }
    public void postOrder(){
        postOrder(0);
    }

    public void preOrder(int index){
        if (arr == null && arr.length == 0){
            System.out.println("ArrBinaryTree is empty");
        }else{
            System.out.println(arr[index]);
            if (2*index + 1 < arr.length){
                preOrder(2*index +1);
            }
            if (2*index + 2 < arr.length){
                preOrder(2*index +2);
            }
        }
    }

    public void midOrder(int index){
        if (arr == null && arr.length == 0){
            System.out.println("ArrBinaryTree is empty");
        }else{

            if (2*index + 1 < arr.length){
                midOrder(2*index +1);
            }
            System.out.println(arr[index]);

            if (2*index + 2 < arr.length){
                midOrder(2*index +2);
            }
        }
    }

    public void postOrder(int index){
        if (arr == null && arr.length == 0){
            System.out.println("ArrBinaryTree is empty");
        }else{

            if (2*index + 1 < arr.length){
                postOrder(2*index +1);
            }
            if (2*index + 2 < arr.length){
                postOrder(2*index +2);
            }
            System.out.println(arr[index]);
        }
    }
}
