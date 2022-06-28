package com.learn.dsalgo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Input: s = "cbaebabacd", p = "abc"
 * Output: 2
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class OccurencesOfAnagrams {
    

    public static void main(String[] args){
          System.out.println(countAnagrams("forfxorfxdofr", "for"));
    }

    static int countAnagrams(String input, String p){
        Map<String, Integer> pMap = new HashMap<>();
        int ans = 0;
        for(int i=0 ; i< p.length(); i++){
            String ch = p.charAt(i)+ "";
            if(pMap.get(ch) == null){
                pMap.put(ch , 1);
            }else{
                pMap.put(ch, pMap.get(ch) + 1);
            }
        }
        int count = pMap.size();
        int i = 0, j=0;
        while(j < input.length()){
            String ist = input.charAt(i) + "";
            String st = input.charAt(j) + "";
            //reduce the occurence of j once visited.
            if(pMap.get(st) != null){
                pMap.put(st, pMap.get(st)-1);
                if(pMap.get(st) == 0){
                    count --;
                }
            }
            //window length achived, find ans and slide the window
            if(j-i+1 == p.length()){
                if(count == 0){
                    ans++;
                }
                //here the calculation for i is reverted back since i is going to get increased.
                if(pMap.get(ist) != null){
                    pMap.put(ist, pMap.get(ist)+1);
                    if(pMap.get(ist) == 1){
                        count ++;
                    }
                }
               i++;
            }
            j++;
        }
        return ans;
    }
}
