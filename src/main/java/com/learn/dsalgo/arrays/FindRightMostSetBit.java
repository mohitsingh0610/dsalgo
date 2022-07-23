package com.learn.dsalgo.arrays;

public class FindRightMostSetBit {
    public static void main(String[] str){
        int INT_SIZE = 32;
        int pos = 1;
        int num = 10;
        // counting the position of first set bit
        for (int i = 0; i < INT_SIZE; i++) {
            if ((num & (1 << i))== 0)
                pos++;
             
            else
                break;
        }
        System.out.println(pos);
    }
}
