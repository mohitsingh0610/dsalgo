package com.learn.dsalgo.recursion;

public class Factorial {
    
    public static void main(String[] str){
     System.out.println(factorial(4));
    }

    static int factorial(int n){
        if (n <= 1){
          return 1;
        }
        return n * factorial(n-1);
    }
}
