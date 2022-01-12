package com.learn.dsalgo.hashtable;

public class Entry<K,V> {

    K key;
    V value;
    final int hashCode;

    Entry<K, V> next;
 
    // Constructor
    public Entry(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
    
}
