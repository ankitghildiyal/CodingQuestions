package com.aghildiyal;

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
