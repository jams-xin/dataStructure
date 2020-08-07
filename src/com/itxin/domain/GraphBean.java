package com.itxin.domain;

import java.util.ArrayList;

/**
 * @ClassName GraphBean
 * @Description TODO
 * @Author Yuan Yunxin
 * @Data 2020/7/29 11:26
 * @Version 1.0
 **/
public class GraphBean {
    public int [][] edges;
    public int numOfEdges;
    public ArrayList<String> vertexList;

    public GraphBean(int num) {
        this.edges = new int[num][num];
        this.numOfEdges = 0;
        this.vertexList = new ArrayList<String>(num);
    }
}
