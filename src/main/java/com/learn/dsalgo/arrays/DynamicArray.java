package com.learn.dsalgo.arrays;

@SuppressWarnings("*")
public class DynamicArray<T> {

    private T[] arr;

    private int capacity = 16 ;

    private int len;

    public DynamicArray(){
        this(16);
    };
    
    public DynamicArray(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Illegal capacity" + capacity);
        }
        this.capacity = capacity;
        arr =  (T[]) new Object[capacity];
    };

    public int size(){
        return this.arr.length;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public T get(int i){
        return arr[i];
    }

    public void set(T element, int i){
        arr[i] =  element;
    }

    public void add(T t){
        if(len + 1 >= capacity){
            if(capacity ==0 ) capacity =1;
            else capacity *= 2;
            T[] newArr =  (T[]) new Object[this.capacity];
            for (int i=0;i< len; i++) {
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }
        arr[len++] = t;
    }

    public T removeAt(int rm_idx){
        if(rm_idx > len || rm_idx<0) throw new  ArrayIndexOutOfBoundsException();
        T data = arr[rm_idx];
        T[] newArr =  (T[]) new Object[len-1];
        for(int i = 0, j= 0; i < len; i++, j++){
            if(i == rm_idx) i++;
            newArr[j] = arr[i];
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    public boolean remove(T obj){
        for(int i= 0; i< len; i++){
            if(arr[i].equals(obj)){
               removeAt(i);
               return true;
            }
        }
        return false;
    }


    public boolean contains(T obj){
        return indexOf(obj) != -1;
    }


    public int indexOf(T obj){
        for(int i= 0; i< len; i++){
            if(arr[i].equals(obj)){
               return i;
            }
        }
        return -1;
    }
    

    @Override
    public String toString(){
     if (len == 0) return "[]";
     StringBuilder sb = new StringBuilder();
     sb.append("[");
     for(int i= 0; i< len; i++){
        if(i ==len-1){
            sb.append(arr[i]);
        }else{
            sb.append(arr[i]).append(", ");
        }
     }
      sb.append("]");
      return sb.toString();
    }
}
