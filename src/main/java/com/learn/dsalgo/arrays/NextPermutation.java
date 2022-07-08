package com.learn.dsalgo.arrays;

import java.util.stream.Stream;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]
 */

public class NextPermutation {
    
    public static void main(String[] args){
      int[] arr = {2,3,1,3,3};
      nextPermutation(arr);
      for(int a:arr){
        System.out.print(a + "");
      }
    }
/**
 * a) Traverse from the right and find the first item that is not following the ascending order. For example in “abedc”, the character ‘b’ does not follow the ascending order.
b) Swap the found character with the closest greater (or smallest greater) element on the right side of it. In the case of “abedc”, we have ‘c’ as the closest greater element. After swapping ‘b’ and ‘c’, the string becomes “acedb”.
c) After swapping, reverse the string after the position of the character found in step a. After reversing the substring “edb” of “acedb”, we get “acbde” which is the required next permutation. 
 * @param nums
 */
    static void nextPermutation(int[] nums){

        int foundIdx = -1;
        int swapIdx  = -1;
        for(int i = nums.length -2; i >= 0 ; i--){
               if(nums[i] < nums[i+1]){
                foundIdx =   i;
                swapIdx = i+1;
                break;
               }
        }
        if(foundIdx == -1){
            reverse(nums, 0);
            return;
        }
        //this can be replaced with binary search as the sequence after foundIdx is sorted.
        for(int i= foundIdx + 1; i< nums.length; i++){
            if(nums[i] <= nums[swapIdx]  && nums[i] > nums[foundIdx] ){
                 swapIdx = i;
            }
        }
        swap(nums, foundIdx, swapIdx);
        reverse(nums, foundIdx +1);
    }

    public static void reverse(int[] arr, int startIndex) {
        for(int i=startIndex,j=arr.length-1; i <= j; i++,j--){
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] =  arr[j] ;
        arr[j] = temp;
    }
}
