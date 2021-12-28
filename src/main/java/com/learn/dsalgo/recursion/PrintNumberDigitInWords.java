package com.learn.dsalgo.recursion;

public class PrintNumberDigitInWords {

    public static void main(String[] str){
        
        String[] digitWords =  {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
         printDigitInWords(123344, digitWords);
    
    }
    
    static void printDigitInWords(int digit, String[] digitWords){
       if(digit == 0){
           return;
       }
       printDigitInWords((digit / 10), digitWords);
       System.out.print(digitWords[digit%10]+" ");
    } 
}
