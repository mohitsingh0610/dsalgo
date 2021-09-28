package com.learn.dsalgo.stack;

import com.learn.dsalgo.dll.DoublyLinkList;

public class Stack<T> {

    private DoublyLinkList<T> list =  new DoublyLinkList<>();


    /**
     * returns size
     * @return
     */
    public int size(){
        return list.size();
    }

    /**
     * Returns true if empty else returns false.
     * @return
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * push element in stack.
     * @param data
     * @return
     */
    public boolean push(T data){
        if(list.isEmpty()){
            list.addFirst(data);
            return true;
        }
        list.addLast(data);
        return true;
    }

    /**
     * pop element from stack.
     * @return
     */
    public T pop(){
        if(list.isEmpty()){
            throw  new RuntimeException("Nothing to pop. Stack is empty.");
        }
        return list.removeLast();
    }
    
    /**
     * peek first element.
     * @return
     */
    public T peek(){
        if(list.isEmpty()){
            throw  new RuntimeException("Stack is empty.");
        }
        return list.peekLast();
    }

    public int search(T elem) {
        return list.indexOf(elem);
      }
    
    public String toString(){
        return list.toString();
    }
}
