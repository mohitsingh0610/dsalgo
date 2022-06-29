package com.learn.dsalgo.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/**
 * Given an array containing N integers and an integer K., 
 * Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
Example 1:
Input : A[] = {10, 5, 2, 7, 1, 9} , K = 15
Output : 4
Explanation: The sub-array is {5, 2, 7, 1}.
 */
public class LongestSubArraySumK {
     
    public static void main(String[] args){
        //int[] A = {10, 5, 2, 7, 1, 9};
        int[] A =  {-1, 2, 3};

        System.out.println(longestSubArraySumK(A, A.length, 6));
    }
 /**
  * Initialize sum = 0 and maxLen = 0.
    1. Create a hash table having (sum, index) tuples.
    2. For i = 0 to n-1, perform the following steps:
    3. Accumulate arr[i] to sum.
    4. If sum == k, update maxLen = i+1.
    5. Check whether sum is present in the hash table or not. If not present, then add it to the hash table as (sum, i) pair.
    6. Check if (sum-k) is present in the hash table or not. If present, then obtain index of (sum-k) from the hash table as index. Now check if maxLen < (i-index), then update maxLen = (i-index).
    7. Return maxLen.
  * @param A
  * @param N
  * @param K
  * @return
  */
    static int longestSubArraySumK(int A[], int N, int K){
        int result = 0;
        Map<Long, Integer> sumToIndexMap =  new HashMap<>();
        int j=0;
        long sum = 0l;
        while(j < N){
            sum = sum + A[j];

            //this check is important because if we add sum again with same value longest window size will reduce.
            if (!sumToIndexMap.containsKey(sum)) {
                sumToIndexMap.put(sum, j);
            }
           
            //this is to handle if sum is equal to k.
            if(sum == K){
                result = j+1;
            }
            if(sumToIndexMap.containsKey(sum -K)){
               int window = j - sumToIndexMap.get(sum -K);
               if(window > result){
                    result = window;
               }
            }
            j++;
        }
        return result;
    }
}
