package com.aghildiyal;

/**
 * Provides four methods -
 * 1) push - Adds an element to stack
 * 2) pop - returns the top element of stack and removes it from the stack. Returns null if empty
 * 3) peek - returns the top element of stack. Returns null if empty
 * 4) isEmpty - Check if Stack has any elements or not;
 *
 *
 */
public class StackImplementation<T> {
    ListNode<T> head;

    public void push(T value){
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }else{
            T headVal = head.val;
            head = head.next;
            return headVal;
        }
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }else{
            return  head.val;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }


}
