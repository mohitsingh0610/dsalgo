package com.learn.dsalgo.recursion;

public class PrintNNumbers {

    public static void main(String[] str){
        print(10);
    }

    public static void print(int n){
        if(n < 1){
            return ;
        }
        //System.out.println(n);
        print(n -1);
        System.out.println(n);
    }
    
}
