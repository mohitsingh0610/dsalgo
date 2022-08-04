package com.learn.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Elements(>N/3 times) | Find the elements that appears more than N/3 times in the array
 * Input: N = 5, array[] = {1,2,2,3,2}
 * Ouput: 2
 */
public class MajorityElementNBy3 {
    public static void main(String[] args){
     int[] nums =  new int[]{3,2,3};
     System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result =  new ArrayList<>();
        int count1 = 0;
        int num1 = -1;
        int count2 = 0;
        int num2 = -1;
        //This step would give the two majority elements from the array
        for(int i=0; i< nums.length; i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }else if(count1 ==0){
                num1 = nums[i];
                count1++;
            }else if(count2 == 0){
                num2 = nums[i];
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        // This would check if the majority elements from above step appears more than N/3 times in the array
        count1=0;
        count2=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i]== num2){
                count2++;
            }
        }
        if(count1 > nums.length/3 ){
            result.add(num1);
        }
        if(count2 > nums.length/3){
            result.add(num2);
        }
        return result;
    }
}
