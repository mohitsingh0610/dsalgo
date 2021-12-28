package com.learn.dsalgo.queue;

import com.learn.dsalgo.common.EmptyQueueException;
import com.learn.dsalgo.dll.DoublyLinkList;

public class Queue<T> {
    
    private DoublyLinkList<T> list =  new DoublyLinkList<>();

    public int size(){
       return this.list.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public T peek(){
        if(list.isEmpty()){
            throw new EmptyQueueException();
        }
        return list.peekFirst();
    }

    public T poll(){
        if(list.isEmpty()){
            throw new EmptyQueueException();
        }
        return list.removeFirst();
    }

    public void offer(T element){
       list.addLast(element);
    }
}
