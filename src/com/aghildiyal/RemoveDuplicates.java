package com.aghildiyal;


/**
 * Problem - Remove duplicate from LinkedList.
 * Algorithm runs in O(1) space but O(N^2) time.
 */
public class RemoveDuplicates {

    public static void removeDuplicates(Node head){

        Node pointer1 = head;

        while(pointer1 != null){
            Node pointer2 = pointer1;
            while(pointer2.next != null){
                if(pointer1.val == pointer2.next.val){
                    pointer2.next = pointer2.next.next;
                }else{
                    pointer2 = pointer2.next;
                }
            }

            pointer1 = pointer1.next;

        }
    }
}

class Node{
    int val;
    Node next;
    public  Node(int val){
        this.val = val;
    }
}
