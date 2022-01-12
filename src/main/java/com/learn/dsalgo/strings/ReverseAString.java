package com.learn.dsalgo.strings;

public class ReverseAString {
    
    public static void main(String[] args){
      char[] str1 = new char[]{'H','a','n','n','a','h'};
      char[] str2 = new char[]{'h','e','l','l','o'};
      reverseString(str1);
      reverseString(str2);
      System.out.println(str1);
      System.out.println(str2);
    }

    public static void reverseString(char[] s) {
        for(int i=0,j=s.length-1; i <= j; i++,j--){
            char temp = s[i];
            s[i] =  s[j] ;
            s[j] = temp;
        }
    }
}
