package com.itxin.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName HeapSortDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/24 20:36
 * @Version 1.0
 **/
public class HeapSortDemo {
    public static void main(String[] args){
        System.out.println("Hello dataStructure! I am HeapSortDemo");
        // test01
        int testarr01[] = {4, 6, 8, 5, 9};

        //test02
        int testarr02[] = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            testarr02[i] = (int) (Math.random() * 10000000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("before sort time is : " + date1Str);

//        adjustHeap(testarr01, 1, testarr01.length);
//        System.out.println("第一次" + Arrays.toString(testarr01)); // 4, 9, 8, 5, 6
//        adjustHeap(testarr01, 0, testarr01.length);
//        System.out.println("第2次" + Arrays.toString(testarr01)); // 9,6,8,5,4

        heapSort(testarr02);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("after sort time is : " + date2Str);
    }

    public static void heapSort(int[] arr){
        /**
         * @param int[] arr
         * @return no
         * @description 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
         */
        int temp = 0;
        // first
        for(int i = arr.length / 2 -1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }

        //second 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        //third 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，
        //反复执行调整+交换步骤，直到整个序列有序
        for (int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    public static void adjustHeap(int[] arr, int index, int length){
        /**
         * @param int[] 待调整的数组
         * @param int index 表示非叶子结点在数组中索引
         * @param int length 表示对多少个元素继续调整， length 是在逐渐的减少
         * @return no
         * @description 完成将以index对应的非叶子结点的树调整成大顶堆
         */
        int temp = arr[index]; //先取出当前元素的值，作为当前父节点
        for (int k = 2*index + 1; k < length; k = 2*k + 1){
            // first 先左右节点比较,说明左子结点的值小于右子结点的值
            if(k+1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            //second 上下父子节点比较,如果子结点大于父结点,把较大的值赋给当前结点
            if (arr[k] > temp){
                arr[index] = arr[k];
                index = k;
            }else{
                break;
            }
        }
        arr[index] = temp;
    }
}
