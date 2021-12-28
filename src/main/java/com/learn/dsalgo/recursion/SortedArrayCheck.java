package com.learn.dsalgo.recursion;

public class SortedArrayCheck {

    public static void main(String[] args){
      int[] arr = {1,4,5,6,8,8};
      System.out.println(isSorted(1, arr));
    }

    static boolean isSorted(int index, int[] arr){
        if(index >= arr.length){
            return true;
        }
        if(arr[index] < arr[index-1]){
            return false;
        }
        return isSorted(index+1, arr);
    }
}

