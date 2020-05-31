package com.aghildiyal;

public class KthToLast {

    public static void main(String[] s){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printKthToLastElement(node1, 3);

    }

    private static int printKthToLastElement(Node n, int k){

        if(n.next == null)
            return 1;
        else{
            int position = 1+ printKthToLastElement(n.next, k);
            if(position == k){
                System.out.println("the Kth to last element is " + n.val);
            }
            return position;
        }
    }


}
