package com.aghildiyal;

public class QueueImplementation<T> {

    ListNode<T> first;
    ListNode<T> last;

    public T pop(){
        if(isEmpty()){
            throw new EmptyException("Queue Empty");
        }
        T toReturn = first.val;
        first = first.next;
        return toReturn;
    }

    public void push(T val){
        ListNode<T> toAdd = new ListNode(val);
        if(isEmpty()){
            first = toAdd;
        }else{
            last.next = toAdd;
        }
        last = toAdd;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyException("Queue Empty");
        }
        return first.val;
    }

    public boolean isEmpty(){
        return first == null;
    }

}
