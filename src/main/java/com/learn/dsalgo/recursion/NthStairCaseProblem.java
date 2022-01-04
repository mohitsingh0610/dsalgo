package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NthStairCaseProblem {

    public static void  main(String[] str){
      Scanner sc = new Scanner(System.in);
      int noOfStairs = sc.nextInt();
      String steps = sc.next(); 
      System.out.println(nthStairCase(noOfStairs,steps));
      sc.close();
    }

    private static List<String> nthStairCase(int n, String steps){
       if(n==0){
           List<String> p =  new ArrayList<>();
           p.add("");
           return p;
       }else if(n < 0){
          List<String> p =  new ArrayList<>();
          return p;
       }
       List<String> paths = new ArrayList<>(); 
       for(int i=0; i< steps.length(); i++){
           char c = steps.charAt(i);
           int step = c - '0';
           List<String> path = nthStairCase(n-step,steps);
           for(String p: path){
              paths.add(c+p);
           }
       }
       return paths;
    }
}
