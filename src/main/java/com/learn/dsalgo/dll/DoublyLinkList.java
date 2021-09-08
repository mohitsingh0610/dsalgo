package com.learn.dsalgo.dll;

public class DoublyLinkList<T> {

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

    /**
     * Adds element after tail. O(1)
     * 
     * @param data
     */
    public void addLast(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null, null);
        } else {
            tail.next = new Node<T>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Adds element at head. O(1)
     * 
     * @param data
     */
    public void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null, null);
        } else {
            head.prev = new Node<T>(data, null, head);
            head = head.prev;
        }
        size++;
    }

    /**
     * Adds element at given index.
     * 
     * O(n)
     * 
     * @param idx
     * @param data
     */
    public void addAt(int idx, T data) {
        if (idx < 0) {
            throw new IllegalArgumentException();
        }
        if (idx == 0) {
            addFirst(data);
            return;
        }
        if (idx == size) {
            addLast(data);
            return;
        }
        Node<T> temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        Node<T> node = new Node<>(data, temp, temp.next);
        temp.next.prev = node;
        temp.next = node;
        size++;
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

    /**
     * Removes head and assign a new head O(1)
     * 
     * @return
     */
    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        // Extract the data at the head and move
        // the head pointer forwards one node
        T data = head.data;
        head = head.next;
        --size;

        // If the list is empty set the tail to null
        if (isEmpty()) {
            tail = null;
        } else {
            // Do a memory cleanup of the previous node
            head.prev = null;
        }
        return data;
    }

    /**
     * Removes tail and assign a new tail O(1)
     * 
     * @return
     */
    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("Empty list");
        // Extract the data at the tail and move
        // the tail pointer backwards one node
        T data = tail.data;
        tail = tail.prev;
        --size;

        // If the list is empty set the head to null
        if (isEmpty()) {
            head = null;
        } else {
            // Do a memory cleanup of the new tail node
            tail.next = null;
        }
        return data;
    }

    private T remove(Node<T> node) {

        if (node.prev == null) {
            removeFirst();
        }
        if (node.next == null) {
            removeLast();
        }
        node.next.prev = node.prev;
        node.prev.next = node.next;
    
        // Temporarily store the data we want to return
        T data = node.data;
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    /**
     * Removes element from list at specific index.
     * 
     * @param index
     * @return
     */
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return null;
        }
        int i;
        Node<T> trav ;
        // this is done to minimise the search.
        if (index < size / 2) {
            for (i = 0, trav = head; i != index - 1; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    /**
     * Removes element from list. O(n)
     * 
     * @param elem
     */
    public boolean remove(T elem) {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        Node<T> trav = head;
        if (elem == null) {
            for (; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (; trav != null; trav = trav.next) {
                if (trav.data.equals(elem)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get index of specified element. O(n)
     * 
     * @param elem
     * @return
     */
    public int indexOf(T elem) {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        Node<T> trav = head;
        if (elem == null) {
            for (int i = 0; trav != null; trav = trav.next, i++) {
                if (trav.data == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; trav != null; trav = trav.next, i++) {
                if (trav.data.equals(elem)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Check is a value is contained within the linked list
    public boolean contains(T obj) {
        return indexOf(obj) != -1;
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

    private static class Node<T> {

        private T data;

        private Node<T> next;

        private Node<T> prev;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

}
