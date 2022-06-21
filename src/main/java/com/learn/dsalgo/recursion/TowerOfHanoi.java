package com.learn.dsalgo.recursion;

import java.util.Scanner;

//o(2 to the power n)
public class TowerOfHanoi {

    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String a = sc.next();
      String b = sc.next();
      String c = sc.next();
      toh(n, a, b, c);
      sc.close();
    }
    
    private static void toh(int n, String from_rod, String to_rod, String aux_rod){
        if(n <=0 ){
            return;
        }
        toh(n-1,from_rod, aux_rod, to_rod); //will print the instruction to move n-1 disks from tower a to tower c using tower b adhering to rules.
        System.out.println(n + "["+ from_rod + "->" + to_rod + "]");
        toh(n-1, aux_rod, to_rod, from_rod); //will print the instruction to move n-1 disks from tower c to tower b using tower a adhering to rules.
    }
}
