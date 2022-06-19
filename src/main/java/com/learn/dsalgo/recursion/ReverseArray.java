package com.learn.dsalgo.recursion;

public class ReverseArray {
    
    public static void main(String[] str){
        Integer[] arr = {1,4,5,6,8,8,9,10};
        reverse(arr, 0);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void reverse(Integer[] a, int i){
          
        int n = a.length;
        if(i >= n/2){
            return ;
        }
        a[n-i-1] = a[n-i-1] + a[i];
        a[i] = a[n-i-1] - a[i];
        a[n-i-1] = a[n-i-1] - a[i];
        reverse(a, i+1);
    }
}
