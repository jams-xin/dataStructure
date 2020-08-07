package com.itxin.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName GraphDemo
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/29 11:20
 * @Version 1.0
 **/
public class GraphDemo {
    public static void main(String[] args) {
        System.out.println("Hello dataStructure I am GraphDemo!");
        int num = 8;  //结点的个数
//        String[] Vertexs = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        GraphDemo graph = new GraphDemo(num);
        graph.insertVertex(Vertexs);

        //A-B A-C B-C B-D B-E
//        graph.insertEdge(0, 1, 1);
//        graph.insertEdge(0, 2, 1);
//        graph.insertEdge(1, 2, 1);
//        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);

        //更新边的关系
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);

        graph.showGraph();
//        graph.dfs();
        graph.bfs(0);

    }

    public int [][] edges;
    public int numOfEdges;
    public ArrayList<String> vertexList;
    public boolean[] isVisit;

    public GraphDemo(int num) {
        //init graph 邻接矩阵表示
        edges = new int[num][num];
        numOfEdges = 0;
        vertexList = new ArrayList<>(num);
        isVisit = new boolean[num];
    }

    public void insertVertex(String[] vertexs){
        //insert vertex
        for(String vertex: vertexs) {
            vertexList.add(vertex);
        }

    }

    public void insertEdge(int v1, int v2, int edge){
        // insert edge
        edges[v1][v2] = edge;
        edges[v2][v1] = edge;
        numOfEdges ++;
    }
    public int getFirstVertex(int i){
        for (int j = 0; j < vertexList.size(); j ++){
            if (edges[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }
    public int getSecondVertex(int v1, int v2){
        for (int j = v2 + 1; j < vertexList.size(); j ++){
            if (edges[v1][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    public void showGraph() {
        for (int[] edge : edges){
            System.out.println(Arrays.toString(edge));
        }
    }

    public void dfs(int i){
        // first
        System.out.println(vertexList.get(i));
        isVisit[i] = true;

        //second
        for (int j = 0; j < vertexList.size(); j ++){
            if (edges[i][j] == 1 && !isVisit[j]){
                dfs(j);
            }
        }
    }

    public void dfs(){
        // 重载
        for(int i = 0; i < vertexList.size(); i ++) {
            if (!isVisit[i]) {
                dfs(i);
            }
        }
    }

    public void bfs(int i){
//        int u;
//        int j;
        // first
        LinkedList queue = new LinkedList();
        System.out.println(vertexList.get(i));
        isVisit[i] = true;
        queue.addLast(i);

        while(!queue.isEmpty()){
            i = (Integer) queue.removeFirst();
            for (int j = 0; j < vertexList.size(); j ++){
                if (edges[i][j] == 1 && !isVisit[j]) {
                     isVisit[j] = true;
                     System.out.println(vertexList.get(j));
                     queue.addLast(j);
                }
            }
//             u = (Integer) queue.removeFirst();
//             j = getFirstVertex(u);
//             while (j != -1){
//                 if(!isVisit[j]){
//                     isVisit[j] = true;
//                     System.out.println(vertexList.get(j));
//                     queue.addLast(j);
//                 }
//                 j = getSecondVertex(u, j);
//             }
        }
    }
//    public void bfs(){
//        // 重载
//        for(int i = 0; i < vertexList.size(); i ++) {
//            if (!isVisit[i]) {
//                bfs(i);
//            }
//        }
//    }


}
