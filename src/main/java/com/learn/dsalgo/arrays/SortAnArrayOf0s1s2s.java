package com.learn.dsalgo.arrays;

/**
 * Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
 * Using Dutch National flag algorithm 
 * 
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */

public class SortAnArrayOf0s1s2s {
    public static void main(String[] args){
      int[] nums = {0, 1, 2, 0, 1, 2};
       sortColors(nums);
       for(int a:nums){
        System.out.print(a + " ");
      }
    }


    static void sortColors(int[] nums) {
        
        int low = 0, mid =0;
        int hi = nums.length-1;

        while(mid <= hi){
            switch(nums[mid]){
                case 0: 
                 swap(nums, mid, low);
                 mid++; low++;
                 break;
                case 1: 
                  mid++;
                  break;
                case 2: 
                  swap(nums, mid, hi);
                  hi--;
                  break;
            }
        }
    } 

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] =  arr[j] ;
        arr[j] = temp;
    }
}
