package com.learn.dsalgo.arrays;

/**
 * You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. 
 * The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
 * Input Format:  array[] = {3,1,2,5,3}
 * Result: {3,4)
 * Explanation: A = 3 , B = 4 
 * Since 3 is appearing twice and 4 is missing
 */
public class FindRepeatAndMissingElementUsingBitManipulation {
    
    public static void main(String[] str){
      int[] nums = new int[]{1,3,3};
      int[] result =  repeatedNumber(nums, nums.length); 
      for(int i: result){
        System.out.println(i);
      }
   } 

    public static int[] repeatedNumber(final int[] arr, int n) {
      int[] result = new int[2];
      int xor = 0;
      for(int i=0; i< n; i++){
        xor = xor^arr[i];
      }
 
      for(int i=1; i<= n; i++){
        xor = xor^i;
      }
      int bucket1 = 0;
      int bucket2 = 0;
      //this would find right most set bit in final xor and also create a mask.
      int rightMostSetPosOfFinalXor = xor & ~(xor -1);
      /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
    //int mask = 1 << rightMostSetPosOfFinalXor;
      for(int i=0; i<n;i++){
        //check the bit at rightMostSetPosOfFinalXor position and do the bucketing
        int bitAtPos = rightMostSetPosOfFinalXor & arr[i];
        if(bitAtPos == 0){
            bucket1 = bucket1 ^ arr[i];
        }else{
            bucket2 = bucket2 ^ arr[i];
        }
      }
      for(int i=1; i<=n;i++){
        //check the bit at rightMostSetPosOfFinalXor position and do the bucketing
        int bitAtPos = rightMostSetPosOfFinalXor & i;
        if(bitAtPos == 0){
            bucket1 = bucket1 ^ i;
        }else{
            bucket2 = bucket2 ^ i;
        }
      }
      for(int i =0; i< n;i++){
         if(arr[i] == bucket1){
            result[0] = bucket1;
            result[1] = bucket2;
            break;
         }else if(arr[i] == bucket2){
            result[0] = bucket2;
            result[1] = bucket1;
            break;
         }
      }
      return result;
    }

}
