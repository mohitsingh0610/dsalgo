package com.learn.dsalgo.recursion;

/**
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. 
 * The output should be printed in sorted increasing order of strings
 */
public class PermutationWithSpaces {
    
    public static void main(String[] args){

        String s = "ABCD";

        String input = s.substring(0, 1);//A
        String output = s.substring(1);//BC
        permutationWithSpaces(input, output);
    }

    static void permutationWithSpaces(String val, String input){
        if(input.length() == 0){
             System.out.println(val);
             return;
        }
        char c1 = input.charAt(0);
        permutationWithSpaces(val+" "+c1, input.substring(1)); //val = A B, input =C
        permutationWithSpaces(val+c1, input.substring(1)); //val = AB, input =C
    }
}
