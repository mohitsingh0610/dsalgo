package com.learn.dsalgo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find length of the longest substring with all distinct characters. 
Example 1:
Input:
S = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest 
substring with all distinct characters.
 */
public class LongestSubstringWithoutRepeatingChar {
    
    public static void main(String[] args) {
        System.out.println(longestSubstrDistinctChars("geeksforgeeks"));
    }
    
    static int longestSubstrDistinctChars(String s){
        int result = 0;
        Map<Character, Integer> temp = new HashMap<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (temp.get(ch) != null) {
                temp.put(ch, temp.get(ch) + 1);
            } else {
                temp.put(ch, 1);
            }
            int uniqueCharSize = temp.keySet().size();
            if (uniqueCharSize == j - i + 1) {
                int window = j - i + 1;
                if (window > result) {
                    result = window;
                }
            } else if(uniqueCharSize < j - i + 1){
                while (temp.keySet().size() != j - i + 1) {
                    char chi = s.charAt(i);
                    temp.put(chi, temp.get(chi) - 1);
                    if (temp.get(chi) == 0) {
                        temp.remove(chi);
                    }
                    i++;
                }
            }
            j++;
        }
        return result;
    }
}
