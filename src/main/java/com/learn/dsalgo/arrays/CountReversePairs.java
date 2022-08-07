package com.learn.dsalgo.arrays;

/**
 * Given an array of numbers, you need to return the count of reverse pairs.
 * Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].
 */
public class CountReversePairs {

    int count = 0;

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        //int[] nums = {2,4,3,5,1};
        System.out.println(new CountReversePairs().reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums,0, nums.length -1);   
        return count;
    }

    private int[] mergeSort(int arr[], int l, int r) {
        if (l == r) {
            int[] ba = new int[1];
            ba[0] = arr[l];
            return ba;
        }
        // Find the middle point
        int m = l + (r - l) / 2;
        int[] arr1 = mergeSort(arr, l, m);
        int[] arr2 = mergeSort(arr, m + 1, r);
        return mergeSortedArrays(arr1, arr2);
    }

    private int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] merged = new int[arr1.length + arr2.length];
        for(i = 0;i<= arr1.length-1;i++) {
            while(j<=arr2.length-1 && arr1[i] > (2 * (long) arr2[j])) {
                j++;
            }
            count += j;
        }
        i=0;
        j=0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                k++;
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < arr1.length) {
            merged[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            merged[k] = arr2[j];
            k++;
            j++;
        }
        return merged;
    }

}
