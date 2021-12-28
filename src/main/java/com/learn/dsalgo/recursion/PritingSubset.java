package com.learn.dsalgo.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PritingSubset {
    
    private static int totalSubsets = 0;
    public static void main(String[] args){

      //should print 2 to the power n subsets
      printSubset(Arrays.asList(1,2,3,4), new LinkedList<Integer>(), 0);
      System.out.println("Total subsets are - "+ totalSubsets);
    }

    static void printSubset(List<Integer> input, LinkedList<Integer>  output, int index){
        if(index >= input.size()){
            for(int a: output){
                System.out.print(a + " ");
            }
            totalSubsets ++;
            System.out.println();
            return;
        }
        //Don't take
        printSubset(input, new LinkedList(output), index +1);
        //take
        output.addLast(input.get(index));
        printSubset(input, new LinkedList(output), index +1);
    }
}
