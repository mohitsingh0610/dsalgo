package com.learn.dsalgo.arrays;

import java.util.Arrays;

/**
Given an array of n integers and a positive number k. We are allowed to take any k integers from the given array. 
The task is to find the minimum possible value of the difference between maximum and minimum of K numbers.
Examples: 
Input : arr[] = {10, 100, 300, 200, 1000, 20, 30}
        k = 3
Output : 20
20 is the minimum possible difference between any
maximum and minimum of any k numbers.
Given k = 3, we get the result 20 by selecting 
integers {10, 20, 30}.
max(10, 20, 30) - min(10, 20, 30) = 30 - 10 = 20.

Input : arr[] = {1, 2, 3, 4, 10, 20, 30, 40, 
                                   100, 200}.
        k = 4      
Output : 3
 */
public class MinDiffKElementInArray {

    private static int minDiff(int[] nums, int k){
        Arrays.sort(nums);
        int min = nums[k -1] - nums[0];
        for(int i = 1; i < nums.length - k + 1; i++){
            int diff = nums[i+k-1] - nums[i];
            if(diff < min){
                min = diff;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {9,4,1,7}; 
        int k = 2;
       System.out.println(minDiff(arr, k)); 
    }
    
}
