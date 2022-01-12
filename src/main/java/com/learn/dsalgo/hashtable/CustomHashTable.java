package com.learn.dsalgo.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomHashTable<K, V> {

    private List<Entry<K, V>> bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    public CustomHashTable() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key)
    {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() coule be negative.
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public void add(K key, V value)
    {
         // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        Entry<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        Entry<K, V> newNode = new Entry<K, V>(key, value, hashCode);
        newNode.next  = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / numBuckets >= 0.7) {
            List<Entry<K, V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
 
            for (Entry<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    // Returns value for a key
    public V get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
          int hashCode = hashCode(key);
       
        Entry<K, V> head = bucketArray.get(bucketIndex);
 
        // Search key in chain
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }
 
        // If key not found
        return null;
    }
 
      // Method to remove a given key
      public V remove(K key)
      {
          // Apply hash function to find index for given key
          int bucketIndex = getBucketIndex(key);
          int hashCode = hashCode(key);
          // Get head of chain
          Entry<K, V> head = bucketArray.get(bucketIndex);
   
          // Search for key in its chain
          Entry<K, V> prev = null;
          while (head != null) {
              // If Key found
              if (head.key.equals(key) && hashCode == head.hashCode)
                  break;
   
              // Else keep moving in chain
              prev = head;
              head = head.next;
          }
   
          // If key was not there
          if (head == null)
              return null;
   
          // Reduce size
          size--;
   
          // Remove key
          if (prev != null)
              prev.next = head.next;
          else
              bucketArray.set(bucketIndex, head.next);
   
          return head.value;
      }

      public static void main(String[] args)
    {
        CustomHashTable<String, Integer> map = new CustomHashTable<>();
        map.add("this", 1);
        map.add("coder", 2);
        map.add("this", 4);
        map.add("hi", 5);
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
