package com.learn.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to B.
 * Input Format:  A = [4, 2, 2, 6, 4] , B = 6
 * Result: 4
 * Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
 */
public class CountSubArraysWithXORK {

    public static void main(String[] args){
        int[] arr =  new int[]{5, 6, 7, 8, 9};
        int B = 6;
        System.out.println(solve(arr, 6));
    }

    //nlog(n)
    public static int solve(int[] A, int B) {
       int count = 0;
       int xr = 0;
       Map<Integer, Integer> map = new HashMap<>();
       for(int i=0; i< A.length; i++){
           xr = xr ^ A[i];
           if(xr == B){
              count++;
           }
           if(map.get(xr^B) != null){
              count = count + map.get(xr^B);
           }
           if(map.get(xr) == null){
             map.put(xr, 1);
           }else{
             map.put(xr, map.get(xr) +1);
           }
           
       }
       return count;
    }
    
}
