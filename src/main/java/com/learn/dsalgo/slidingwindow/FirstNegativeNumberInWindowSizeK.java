package com.learn.dsalgo.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array and a positive integer k, find the first negative integer for
 * each window(contiguous subarray) of size k.
 * If a window does not contain a negative integer, then print 0 for that
 * window.
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 * 
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15 0
 */
public class FirstNegativeNumberInWindowSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> arr = new ArrayList<Integer>(N);

        // Appending new elements at
        // the end of the list
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }
        List<Integer> result = printFirstNegativeInteger(arr, N, K);
        System.out.println(result);
    }


    static List<Integer> printFirstNegativeInteger(List<Integer> arr, int n, int k){
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> temp =  new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        while(j<n){
            //keep adding the negative numbers in a temp list
            if(arr.get(j) < 0){
               temp.add(arr.get(j));
            }
            if(j-i+1 ==k){
                //once the window is hit, the first element in the temp linked list will the first negative number in the given window. If temp list empty, it means
                //that there is no negative number in the window
               if(temp.size() > 0){
                   int firstNegative = temp.get(0);
                   result.add(firstNegative);
                   //check if the first element no in the window is the first negative. If yes, then remove it from temp ll because it wont be part of 
                   //the next window 
                   if(arr.get(i) == firstNegative){
                    temp.remove(0); 
                   }
               }else{
                result.add(0);
               }
               i++;
            }
            j++;
        }
        return result;
    }
}
