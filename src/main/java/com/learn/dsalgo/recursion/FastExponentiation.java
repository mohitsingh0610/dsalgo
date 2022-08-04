package com.learn.dsalgo.recursion;

//O(logn)
public class FastExponentiation {
    
    public static void main(String[] str){
        int pow = -3;
        int n = 3;
        double expo = 0.0d;
        if(pow <0){
            pow = -1 * pow;
            expo = 1.0/getFastExpo(pow,n);
        }else{
            expo =  getFastExpo(pow,n);
        }
        System.out.println(expo);
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
