package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNBitBinaryNumbers {
    private List<String> result =  new ArrayList<>();
    public static void main(String[] args){
        printNBitBinaryNumbers(0, 0, 2, "");
    }

    static void printNBitBinaryNumbers(int zeros, int ones, int n, String output){
        if(n == 0){
         System.out.println(output);
         return;
        }
        printNBitBinaryNumbers(zeros, ones+1, n-1, output + 1);
        if(zeros <ones){
            printNBitBinaryNumbers(zeros + 1, ones, n-1, output + 0);
        }
    }
}
