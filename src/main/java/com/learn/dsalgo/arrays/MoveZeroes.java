package com.learn.dsalgo.arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */
public class MoveZeroes {
    
    public static void main(String[] str){
      int[] nums = new int[]{0,1,0,3,12};
      moveZeroes(nums);
     
      for(int n : nums){
        System.out.println(n);
      }
      
      
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;

        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                nums[count] = nums[i];
                count++;
            }
        }
        for(int i=count; i< nums.length; i++){
            nums[i] =0;
        }
    }
}
