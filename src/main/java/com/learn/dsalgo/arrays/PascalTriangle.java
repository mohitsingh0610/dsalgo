package com.learn.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args){
        System.out.println(generate(5));
    }

    static List<List<Integer>> generate(int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row =  Arrays.asList(1);
        result.add(row);
        for(int i= 1; i<n; i++){
          row =  new ArrayList<>(i+1);
          for(int j=0; j<=i; j++){
            if(j==0 || j==i){
                row.add(1);
            }else{
                row.add(result.get(i-1).get(j) + result.get(i-1).get(j-1)) ;
            }
          }
          result.add(row);
        }
        return result; 
    }

    
}
