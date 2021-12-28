package com.learn.dsalgo.queue;

public class QueueArray<T> {
    
    private Object[] queue;

    private int front;

    private int rear;

    QueueArray(int capacity){
       queue = new Object[capacity];
       
    }
}
