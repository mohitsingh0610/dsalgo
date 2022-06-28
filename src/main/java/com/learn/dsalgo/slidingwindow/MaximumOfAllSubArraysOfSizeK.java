package com.learn.dsalgo.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
 * Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
*/
 
public class MaximumOfAllSubArraysOfSizeK {

    public static void main(String[] args){
      int[] a = {1,2,3,1,4,5,2,3,6} ;
      System.out.println(max_of_subarrays(a, a.length, 3));
    }
    
    
    static List<Integer> max_of_subarrays(int[] arr, int n, int k){
        List<Integer> result = new ArrayList<Integer>();
        int i=0, j=0;
        LinkedList<Integer> max = new LinkedList<>();
        //main calculation here is to use linkedlist and remove all items smaller and before than jth element as these smaller element before will
        //not be used in further while sliding window.
        while(j < n){  
           while(max.size() > 0 && max.getLast() < arr[j]){
            max.removeLast();
           }
           max.addLast(arr[j]);
           if(j-i + 1 == k){ 
               int max1 = max.getFirst(); 
               result.add(max1);
               if(max1 == arr[i]){
                max.removeFirst();
               }
               i++;
            }
           j++;
        }
        return result;
    }
}
