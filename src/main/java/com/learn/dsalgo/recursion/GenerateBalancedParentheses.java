package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateBalancedParentheses {

    public static void main(String[] args){
       System.out.println(generateBalancedParentheses(3,3,"",new ArrayList<String>()));
    }

    public static List<String> generateBalancedParentheses(int ob, int cb, String output, List<String> result){
        
        if(ob ==0 && cb ==0){
            result.add(output);
            return result;
        }

        if(ob != 0){
          generateBalancedParentheses(ob -1, cb, output + "(", result);  
        }
        if(cb > ob){
            generateBalancedParentheses(ob, cb -1, output + ")", result); 
        }
        return result;
    }
    
}
