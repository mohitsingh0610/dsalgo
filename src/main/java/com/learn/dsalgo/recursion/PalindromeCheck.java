package com.learn.dsalgo.recursion;

public class PalindromeCheck {

    

    public static void main(String[] str){
        String st = "1122111";
        char[] arr = st.toCharArray();
        System.out.println(isPalindrome(arr, 0));

    }

    static boolean isPalindrome(char[] a, int i){
        int n = a.length;
        if(i >= n/2){
            return true;
        }
        if(a[i] == a[n-i-1]){
           return isPalindrome(a , i+1);
        }
        return false;
    }
    
}
