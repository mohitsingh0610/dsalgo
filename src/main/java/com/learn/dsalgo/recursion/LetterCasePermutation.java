package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 */
public class LetterCasePermutation {
    
    public static void main(String[] args){

        System.out.println(letterCasePermutation("a1b2", "", new ArrayList<String>()));
    }

    static List<String> letterCasePermutation(String input, String output, List<String> result){
        if(input.length() == 0){
            result.add(output);
            return result;
        }
        char ch = input.charAt(0);
        String lc = "";
        String uc = "";
        if(!Character.isDigit(ch)){
            lc = (""+ch).toLowerCase();
            uc = (""+ch).toUpperCase();
            letterCasePermutation(input.substring(1), output+lc, result);
            letterCasePermutation(input.substring(1), output+uc, result);
        }else{
            letterCasePermutation(input.substring(1), output+ch, result);
        }
        return result;
    }
}
