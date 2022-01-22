package com.learn.dsalgo.ll;

public class CustomLinkedList<T> {

    private int size = 0;

    private Node<T> head = null;

    private Node<T> tail = null;

    // Return the size of this linked list
    public int size() {
        return size;
    }

    // Is this linked list empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    private static class Node<T> {

        private T data;

        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void addLast(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null);
        } else {
            tail.next = new Node<T>(data, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null);
        } else {
            head = new Node<T>(data, head);
        }
        size++;
    }

    public void addAt(int index, T data) {
        if(index < 0 || index > size()){
            throw new IllegalArgumentException("Invalid index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<T>(data, temp.next);
        temp.next = newNode;
    }

    //O(n)
    public T removeLast(){
        T data = tail.data;
        //Checks if the list is empty  
        if(head == null) {  
            System.out.println("List is empty");  
            return null;  
        }  
        else {  
            //Checks whether the list contains only one element  
            if(head != tail ) {  
                Node<T> current = head;  
                //Loop through the list till the second last element such that current.next is pointing to tail  
                while(current.next != tail) {  
                    current = current.next;  
                }  
                //Second last element will become new tail of the list  
                tail = current;  
                tail.next = null;  
                
            }  
            //If the list contains only one element  
            //Then it will remove it and both head and tail will point to null  
            else {  
                head = tail = null;  
            }  
            size--;
        }  
        return data;
    }

    public T removeFirst(){
        T data = head.data;
        if(isEmpty()){
            throw new RuntimeException("Empty list");
        }
        if(head != tail){
            head = head.next;
        }else{
            head = tail = null; 
        }
        size--;
        return data;
    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        return tail.data;
    }

    public void reverse(){
        if(head.next == null){
            return;
        }
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while(current != null){
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
