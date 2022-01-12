package com.learn.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order. Input: nums = [2,7,11,15], target = 9
 * Output: [0,1] Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
      int[] nums = {-2,7,11,15};
      int target = 9;
      int[] result = twoSum(nums, target);
      System.out.println(result[0]+","+result[1]);
      int[] result2 = twoSumBetter(nums, target);
      System.out.println(result2[0]+","+result2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (otherNum == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    found = true; 
                    break;
                }
            }
            if(found == true){
                break;
            }
        }
        return result;
    }

    public static int[] twoSumBetter(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        Map<Integer,Integer> complementMap =  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(complementMap.get(nums[i]) != null){
                result[0] = complementMap.get(nums[i]);
                result[1] = i;
                return result;
            }
            complementMap.put(target-nums[i], i);
        }
        return result;
    }
}
