package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetKeyPadCombination {

    public static String[] codes =  new String[]{".;","abc", "def", "ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args){
      
       Scanner sc = new Scanner(System.in);
       String number = sc.next();
       List<String> words = getKeyPadCombination(number);
       System.out.println(words);
       sc.close();
    }
    
    //should return no of words equal to cartesian product of all letters in code . Eg. 578 i.e. ("mno","tu","vwx") should return 18 words.
    private static List<String>  getKeyPadCombination(String number){
    
      if(number.isEmpty()){
         List<String> test = new ArrayList<>();
         test.add("");
         return test;
       }
       //578 
       char ch = number.charAt(0); //5
       String ros = number.substring(1); //78
       List<String> words = getKeyPadCombination(ros); // returns combinations for 78
       List<String> finalWords = new ArrayList<>(); //
       String codeForCh = codes[ch - '0']; 
       //Iterate through each char in code for 5 and append it to words for 78
       for(int i=0; i<codeForCh.length(); i++){
           char chforch =  codeForCh.charAt(i);
            for(String word : words){
                finalWords.add(chforch+word);
            }
       }
       return finalWords;
    }
    
}
