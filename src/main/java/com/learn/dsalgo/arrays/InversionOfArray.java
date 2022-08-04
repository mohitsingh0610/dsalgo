package com.learn.dsalgo.arrays;

/**
 * Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
 * What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i]
 * Input Format: N = 5, array[] = {1,2,3,4,5}
 * Result: 0
 * Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find a pair 
 * such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.
 */

public class InversionOfArray {
  
    static int count = 0;
    public static void main(String[] args){
       int[] arr = new int[]{34,174,165,142,212,254,369,48,145,163,258,38,360,224,242,30,279,317,36,191,343,289,107,41,443,265,149,447,306,391,230,371,351,7,102};
       //int[] arr = new int[]{5,4,3,2,1};

        mergeSort(arr, 0, arr.length -1);
        System.out.println(count);
    }

    private static int[] mergeSort(int arr[], int l, int r){
             if(l==r){
                int[] ba = new int[1];
                ba[0] = arr[l];
                return ba;
             }
            // Find the middle point
            int m =l+ (r-l)/2;
            int[] arr1 = mergeSort(arr,l,m);
            int[] arr2 = mergeSort(arr,m+1,r);
            return mergeSortedArrays(arr1, arr2);
    }

    private static int[] mergeSortedArrays(int[] arr1, int[] arr2){
        int i=0;
        int j=0;
        int k=0;
        int[] merged = new int[arr1.length+arr2.length];
        while( i< arr1.length && j< arr2.length){
            if(arr1[i]< arr2[j]){
                merged[k] = arr1[i];
                k++;
                i++;
            }else{
                count += arr1.length -i;
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }
        while(i < arr1.length){
            merged[k] = arr1[i];
             k++;
             i++;
        }
        while(j<arr2.length){
            merged[k] = arr2[j];
             k++;
             j++;
        }
        return merged;
    }
}
