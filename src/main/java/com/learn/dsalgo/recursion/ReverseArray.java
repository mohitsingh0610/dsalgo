package com.learn.dsalgo.recursion;

public class ReverseArray {
    
    public static void main(String[] str){
        Integer[] arr = {1,4,5,6,8,8,9,10};
        reverse(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void reverse(Integer[] a, int l, int r){
          
        if(l > r || l==r){
            return ;
        }
        a[r] = a[r] + a[l];
        a[l] = a[r] - a[l];
        a[r] = a[r] - a[l];
        reverse(a, l+1, r-1);
    }
}
