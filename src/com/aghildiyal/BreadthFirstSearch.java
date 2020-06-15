package com.aghildiyal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BreadthFirstSearch {

    public static <T> void search(GraphNode<T> root){
        Queue<GraphNode<T>> q = new ArrayDeque<>();
        root.visited = true;
        System.out.println(root.val);
        q.add(root);
        GraphNode<T> next = q.poll();
        while(next != null){
            for(GraphNode<T> neighbour : next.neighbours){
                if(!neighbour.visited){
                    neighbour.visited = true;
                    System.out.println(neighbour.val);
                    q.add(neighbour);
                }
            }
            next = q.poll();
        }
    }

    public static void main(String[] s){
        GraphNode<Integer> graph1 = new GraphNode(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        graph1.addNeghbour(n2);

        GraphNode<Integer> n3 = new GraphNode<>(4);
        GraphNode<Integer> n4 = new GraphNode<>(3);
        n2.addNeghbour(n3);
        n2.addNeghbour(n4);

        GraphNode<Integer> n5 = new GraphNode<>(5);
        n3.addNeghbour(n5);

        n5.addNeghbour(n4);

        search(graph1);
    }
}
