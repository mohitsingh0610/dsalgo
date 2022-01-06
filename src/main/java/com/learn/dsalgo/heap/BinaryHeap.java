package com.learn.dsalgo.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {

    private List<T> heap = null;

    // Construct and initially empty priority queue
    public BinaryHeap() {
        this(1);
    }

    // Construct a priority queue with an initial capacity
    public BinaryHeap(int sz) {
        heap = new ArrayList<>(sz);
    }

    public BinaryHeap(Collection<T> elems) {

        int heapSize = elems.size();
        heap = new ArrayList<T>(heapSize);

        // Add all elements of the given collection to the heap
        heap.addAll(elems);

        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    private void sink(int i) {
        int heapSize = size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = left;

            if (right < heapSize && less(right, left)) {
                smallest = right;
            }

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(i, smallest))
                break;

            // Move down the tree following the smallest node
            swap(smallest, i);
        }

    }

    // Returns the value of the element with the lowest
    // priority in this priority queue. If the priority
    // queue is empty null is returned.
    public T peek() {
        if (isEmpty())
            return null;
        return heap.get(0);
    }

    // Removes the root of the heap, O(log(n))
    public T poll() {
        return removeAt(0);
    }

    // Adds an element to the priority queue, the
    // element must not be null, O(log(n))
    public void add(T elem) {

        if (elem == null)
            throw new IllegalArgumentException();

        heap.add(elem);

        int indexOfLastElem = size() - 1;
        swim(indexOfLastElem);
    }

    // Perform bottom up node swim, O(log(n))
    private void swim(int k) {

        // Grab the index of the next parent node WRT to k
        int parent = (k - 1) / 2;

        // Keep swimming while we have not reached the
        // root and while we're less than our parent.
        while (k > 0 && less(k, parent)) {
            // Exchange k with the parent
            swap(parent, k);
            k = parent;

            // Grab the index of the next parent node WRT to k
            parent = (k - 1) / 2;
        }
    }

    // Recursively checks if this heap is a min heap
    // This method is just for testing purposes to make
    // sure the heap invariant is still being maintained
    // Called this method with k=0 to start at the root
    public boolean isMinHeap(int k) {
        // If we are outside the bounds of the heap return true
        int heapSize = size();
        if (k >= heapSize)
            return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // Make sure that the current node k is less than
        // both of its children left, and right if they exist
        // return false otherwise to indicate an invalid heap
        if (left < heapSize && !less(k, left))
            return false;
        if (right < heapSize && !less(k, right))
            return false;

        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }

    private void swap(int i, int j) {
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    // Returns true/false depending on if the priority queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Clears everything inside the heap, O(n)
    public void clear() {
        heap.clear();
    }

    // Return the size of the heap
    public int size() {
        return heap.size();
    }

    // Tests if the value of node i <= node j
    // This method assumes i & j are valid indices, O(1)
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    // Removes a node at particular index, O(log(n))
    private T removeAt(int i) {
        if (isEmpty())
            return null;

        int indexOfLastElem = size() - 1;
        T removed_data = heap.get(i);
        swap(i, indexOfLastElem);

        // Obliterate the value
        heap.remove(indexOfLastElem);

        // Check if the last element was removed
        if (i == indexOfLastElem)
            return removed_data;
        T elem = heap.get(i);

        // Try sinking element
        sink(i);

        // If sinking did not work try swimming
        if (heap.get(i).equals(elem))
            swim(i);
        return removed_data;
    }

}
