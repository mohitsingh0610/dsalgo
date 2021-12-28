package com.learn.dsalgo.recursion;

//O(logn)
public class FastExponentiation {
    
    public static void main(String[] str){
        System.out.println(getFastExpo(3,3));
    }

    static int getFastExpo(int pow, int n){
        if(pow==0){
            return 1;
        }
        if(pow %2 ==0){
            return getFastExpo(pow/2, n)*getFastExpo(pow/2, n);
        }else{
            return n*getFastExpo(pow/2, n)*getFastExpo(pow/2, n);
        } 
    }
}
