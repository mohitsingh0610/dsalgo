package com.learn.dsalgo.arrays;

import java.util.Scanner;

/**
 * Find the no of bits required to convert nunber A to number B
 */
public class FindNumberOfBitsReqConvertAToB {
    
    public static void main(String[] args){
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number A");
        int a = sc.nextInt();
        System.out.print("Enter the number B");
        int b = sc.nextInt();
        // First step would be to xor a and b.
        int xor = a ^ b;
        //Now we need to count the number of set bits in xor of a and b to find the answer. The idea here is to set the Least significant set bit to 0 till the
        // xor becomes zero and increase the count.
        while(xor != 0){
            count++;
            //This would set the Least significant set bit to 0
            xor = xor & (xor-1);
        }
        System.out.println("Number of bits required is " + count);
    }
}
