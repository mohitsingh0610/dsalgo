package com.learn.dsalgo.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed. 
 * The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise). 
 * In each step, a certain number of people are skipped and the next person is executed. 
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom.
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle. 
 * The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 */
public class JosephusProblem {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in); 
       int n = sc.nextInt();
       int k = sc.nextInt();
       List<Integer> persons =  new ArrayList<>();
       for(int i=1; i<=n; i++){
         persons.add(i);
       }
       System.out.println(safePosition(persons, k - 1,  0));
    }

    static int safePosition(List<Integer> persons, int k, int killPos){
        if(persons.size() ==1){
            return persons.get(0);
        }
        killPos = (killPos + k) % persons.size();
        persons.remove(killPos);
        //Here the kill pos will automatically become the sword postion for next recursive call because one person is removed from list.
        return safePosition(persons, k, killPos);
    }
}
