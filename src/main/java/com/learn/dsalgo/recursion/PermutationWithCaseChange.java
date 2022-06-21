package com.learn.dsalgo.recursion;

public class PermutationWithCaseChange {
    
    public static void main(String[] args){
        String s = "abc";

        permutationWithCaseChange(s, "");

    }

    static void permutationWithCaseChange(String input, String output){
        if(input.length() == 0){
             System.out.println(output);
             return;
        }
        String c1 = input.substring(0,1);
        permutationWithCaseChange(input.substring(1),output+c1.toUpperCase()); 
        permutationWithCaseChange(input.substring(1), output+c1.toLowerCase());
    }
}
