package com.aghildiyal;

public class DepthFirstSearch {

    public static <T> void search(GraphNode<T> node){

        System.out.println("Looking at Node: " + node.val);
        node.visited = true;
        for(GraphNode g : node.neighbours){
            if(!g.visited)
                search(g);
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
