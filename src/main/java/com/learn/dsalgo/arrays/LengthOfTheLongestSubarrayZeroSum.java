package com.learn.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class LengthOfTheLongestSubarrayZeroSum {
    public static void main(String[] args){
            int[] arr = new int[]{9, -3, 3, -1, 6, -5};
            System.out.println(maxLen(arr,arr.length));
    }

    public static int maxLen(int arr[], int n)
    {
        int result = 0;
        Map<Long, Integer> sumToIndexMap =  new HashMap<>();
        int j=0;
        long sum = 0l;
        while(j < n){
            sum = sum + arr[j];

            //this check is important because if we add sum again with same value longest window size will reduce.
            if (!sumToIndexMap.containsKey(sum)) {
                sumToIndexMap.put(sum, j);
            }
            //this is to handle if sum is equal to k.
            if(sum == 0){
                result = j+1;
            }
            if(sumToIndexMap.containsKey(sum)){
               int window = j - sumToIndexMap.get(sum);
               if(window > result){
                    result = window;
               }
            }
            j++;
        }
        return result;
    }
}
