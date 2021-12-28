package com.learn.dsalgo.recursion;

public class Exponentiation {
    
    public static void main(String[] str){
        System.out.println(getExpo(3,3));
    }

    static int getExpo(int pow, int n){
        if(pow==0){
            return 1;
        }
        return n*getExpo(pow-1, n);    
    }
}
