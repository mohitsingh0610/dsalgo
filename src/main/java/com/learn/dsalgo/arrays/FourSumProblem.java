package com.learn.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of N integers, your task is to find unique quads that add up to give a target value. 
 * In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.
 * 
 * Input Format: arr[] = [1,0,-1,0,-2,2], target = 0
 * Result: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class FourSumProblem {
    
     public static void main(String[] args) {
        int[] input = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(input, target));
    }

    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i =0; i< nums.length; i++){
            for(int j= i+1; j < nums.length; j++){
                int l = j+1;
                int r = nums.length -1;
                //this has be long to handle overflow.
                long twoSum = nums[i] + nums[j];
                long target2 = target - twoSum;
                while(l<r){
                    long temp2 = nums[l] + nums[r];
                    if(temp2 > target2){
                        r--;
                    }else if(temp2 < target2){
                        l++;
                    }else{
                        List<Integer> t =  new LinkedList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[l]);
                        t.add(nums[r]);
                        result.add(t);
                        while(l<r && nums[l] == t.get(2)){
                            l++;
                        }
                        while(l<r && nums[r] == t.get(3)){
                            r--;
                        }
                    } 
                }
                while(j+1 < nums.length && nums[j] == nums[j+1]){
                    j++;
                }
            }
            while(i+1 < nums.length && nums[i] == nums[i+1]){
                i++;
          }
        }
        return result;
    }
}
