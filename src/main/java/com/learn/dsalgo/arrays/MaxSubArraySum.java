package com.learn.dsalgo.arrays;

/**
     * Given an integer array nums, find the contiguous subarray (containing at
     * least one number) which has the largest sum and return its sum.
     * 
     * A subarray is a contiguous part of an array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Example 2:
     * 
     * Input: nums = [1]
     * Output: 1
     * Example 3:
     * 
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     *
     */
public class MaxSubArraySum {

    public static void main(String[] str) {

        int[] nums = new int[] {5,4,-1,7,8};
        //int[] nums = new int[] {-5,-4,-1,-7,-8};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayUsingKadaneAlgo(nums));
    }

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    //O(n)
    private static int maxSubArrayUsingKadaneAlgo(int[] nums){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i< nums.length ; i++){
            currentSum = currentSum + nums[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
