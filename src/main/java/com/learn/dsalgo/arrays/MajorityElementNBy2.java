package com.learn.dsalgo.arrays;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElementNBy2 {
    public static void main(String[] args){
        int nums[] = new int[]{4,4,2,4,3,4,4,3,2,4};
        System.out.println(majorityElement(nums));
    }
    
    // Moore’s Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;
        for(int i=0; i< nums.length; i++){
            if(count ==0){
                result = nums[i];
            }
            if(nums[i] == result){
                count++;
            }else{
                count--;
            }
        }
        return result; 
    }
}
