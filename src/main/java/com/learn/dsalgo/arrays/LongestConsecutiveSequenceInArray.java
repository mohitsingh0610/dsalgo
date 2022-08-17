package com.learn.dsalgo.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array of ‘N’ integers. 
 * You need to find the length of the longest sequence which contains the consecutive elements.
 * Example 1:
 * Input: [100, 200, 1, 3, 2, 4]
 * Output: 4
 */

public class LongestConsecutiveSequenceInArray {

    public static void main(String[] args){
          int[] nums = new int[]{100, 200, 1, 3, 2, 4};
          System.out.println(longestConsecutive(nums));
    }
    

    public static int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length ; i++){
            set.add(nums[i]);
        }
        for(int i=0; i< nums.length ; i++){
            //to check if there exists a number lesser that current number. skip the loop if not enter inot the loop.
            //this condition makes this algo o(n).
            if(!set.contains(nums[i]-1)){
               int currentStreax = 1;
               int currentNum = nums[i];
               while(set.contains(currentNum+1)){
                  currentStreax++;
                  currentNum++;
               }
               if(currentStreax > result){
                result = currentStreax;
               }
            }
        }
        return result;
    }

}
