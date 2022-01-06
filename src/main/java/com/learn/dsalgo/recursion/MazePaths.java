package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazePaths {

    public static void main(String[] args){
      
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(getMazePaths(1,1,m,n));
        sc.close();
    }

    
    private static List<String> getMazePaths(int sr, int sc, int dr, int dc ){
       
       if(sr == dr && sc == dc){
           List<String> bPath = new ArrayList<>();
           bPath.add("");
           return bPath;
       }

       List<String> paths1 = new ArrayList<>(); 
       List<String> paths2 = new ArrayList<>(); 
       List<String> paths = new ArrayList<>();
       if(sc < dc){
         paths1 = getMazePaths(sr, sc+1, dr, dc);
         for(String path: paths1){
            paths.add("h"+path);
         }
       }
       if(sr < dr){
        paths2 = getMazePaths(sr+1, sc, dr, dc);
        for(String path: paths2){
            paths.add("v"+path);
         }
       }
       return paths;
    }
}
