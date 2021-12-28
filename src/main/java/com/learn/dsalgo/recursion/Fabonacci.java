package com.learn.dsalgo.recursion;

public class Fabonacci {

    public static void main(String[] str){
       System.out.println(fabonacci(5));
    }

    static int fabonacci(int n){
        if (n==0 || n==1){
            return n;
        }
       int nthTerm = fabonacci(n-1) + fabonacci(n-2);
       System.out.println(nthTerm);
       return nthTerm;
    }
    
}

