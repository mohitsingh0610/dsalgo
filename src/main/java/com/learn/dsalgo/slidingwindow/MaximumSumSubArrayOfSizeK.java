package com.learn.dsalgo.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of integers Arr of size N and a number K. Return the maximum
 * sum of a subarray of size K.
 * Example -
 * Input:
 * N = 4, K = 2
 * Arr = [100, 200, 300, 400]
 * Output:
 * 700
 * Explanation:
 * Arr3 + Arr4 =700,
 * which is maximum.
 */
public class MaximumSumSubArrayOfSizeK {

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
        System.out.println(maximumSumSubarray(K, arr, N));

    }

    static int maximumSumSubarray(int k, List<Integer> arr, int n) {
        int i = 0, j = 1;
        int max = Integer.MIN_VALUE;
        int sum = arr.get(0);
        while (j < n) {
            sum = sum + arr.get(j);
            if (j - i + 1  == k) {
                if (sum > max) {
                    max = sum;
                }
                sum = sum - arr.get(i);
                i++;
            }
            j++;
        }
        return max;
    }
}
