package com.aghildiyal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode<T> {
    T val;
    List<GraphNode> neighbours;
    boolean visited;

    public GraphNode(T v){
        this.val = v;
        neighbours = new ArrayList<>();
    }

    public void addNeghbour(GraphNode n){
        neighbours.add(n);
    }
}
