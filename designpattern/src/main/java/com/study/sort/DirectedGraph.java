package com.study.sort;

import lombok.val;

import java.util.*;

/**
 * 图的结构
 */
public class DirectedGraph {
    private class Vertex {
        private String vertexLabel;//顶点标识
        List<Edge> edges;//边表
        private int inDegree;//顶点的入度

        public Vertex(String vertexLabel) {
            this.vertexLabel = vertexLabel;
            edges = new ArrayList<>();
            inDegree = 0;
        }
    }
    private class Edge {
        private Vertex endVertex;

        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }
    }

    private Map<String,Vertex> directedGraph;

    public DirectedGraph(List<String> lines) {
        directedGraph = new LinkedHashMap<>();
        buildDirectedGraph(lines);
    }

    private void buildDirectedGraph(List<String> lines) {
        Vertex startNode, endNode;
        String startNodeLabel, endNodeLabel;
        Edge e;
        for (int i = 0; i < lines.size(); i++) {
            String[] nodesInfo = lines.get(i).split(",");
            startNodeLabel = nodesInfo[1];
            endNodeLabel = nodesInfo[2];
            startNode = directedGraph.get(startNodeLabel);
            if(startNode == null){
                startNode = new Vertex(startNodeLabel);
                directedGraph.put(startNodeLabel, startNode);
            }
            endNode = directedGraph.get(endNodeLabel);
            if(endNode == null){
                endNode = new Vertex(endNodeLabel);
                directedGraph.put(endNodeLabel, endNode);
            }

            e = new Edge(endNode);//每读入一行代表一条边
            startNode.edges.add(e);//每读入一行数据,起始顶点添加一条边
            endNode.inDegree++;//每读入一行数据,终止顶点入度加1
        }
    }

    private void toPoSort() throws Exception {
        int count = 0;
        Stack<Vertex> vertices = new Stack<>();// 拓扑排序中用到的栈
        //扫描所有的顶点,将入度为0的顶点入队列
        Collection<Vertex> vertexCollection = directedGraph.values();
        for (Vertex vertex:vertexCollection) {
            if (vertex.inDegree == 0) {
                vertices.push(vertex);
            }
        }
        while (!vertices.isEmpty()) {
            Vertex vertex = vertices.pop();
            System.out.println(vertex.vertexLabel + " ");
            count++;
            for (Edge edge:vertex.edges) {
                if(--edge.endVertex.inDegree == 0) {
                    vertices.push(edge.endVertex);
                }
            }
        }
        if (count != directedGraph.size()) {
            throw new Exception("成环啦~~~");
        }

    }

    public static void main(String[] args) throws Exception {
        List<String> params = new ArrayList<>();
        params.add("1,0,0,0");
        params.add("2,0,0,0");
        params.add("3,1,2,0");
        params.add("4,2,0,0");
        params.add("5,1,2,3");
        params.add("6,1,3,5");
        DirectedGraph directedGraph = new DirectedGraph(params);
        directedGraph.toPoSort();
    }

}
