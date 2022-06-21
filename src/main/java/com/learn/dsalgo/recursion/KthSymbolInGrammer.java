package com.learn.dsalgo.recursion;

public class KthSymbolInGrammer {

    public static void main(String[] args){

        System.out.println(kthSymbol(4, 3));
        System.out.println(kthSymbol(4, 7));
    }

    static int kthSymbol(int n, int k){
        
        if(n==1 && k==1){
            return 0;
        }
        int mid = (int)Math.pow(2, n-2);
        if(k <= mid){
            return kthSymbol(n-1, k);
        }else{
            return 1 ^ kthSymbol(n-1, k-mid);
        }
    }
    
}
