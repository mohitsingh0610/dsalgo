package com.learn.dsalgo.recursion;

import java.util.Scanner;

public class PrintKeyPadCombination {

    public static String[] codes =  new String[]{".;","abc", "def", "ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        printKeyPadCombination(key, "") ;
        sc.close();
    }

    static void printKeyPadCombination(String ques , String ans ){
        if(ques.isEmpty()){
            System.out.print(ans + " ");
            return;
        }
        char ch = ques.charAt(0);
        String str = ques.substring(1);
        String chcode = codes[ch - '0'];
        for(int i=0; i<chcode.length(); i++){
           char c = chcode.charAt(i);
           printKeyPadCombination(str, ans + c);
        }
    }
    
}
