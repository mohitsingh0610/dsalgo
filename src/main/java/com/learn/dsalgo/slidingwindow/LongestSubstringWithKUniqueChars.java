package com.learn.dsalgo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print the size of the longest possible substring
 * that has exactly K unique characters.
 * If there is no possible substring then print -1.
 * Example 1 -
 * Input:
 * S = "aabacbebebe", K = 3
 * Output: 7
 * Explanation: "cbebebe" is the longest
 * substring with K distinct characters.
 */
public class LongestSubstringWithKUniqueChars {

    public static void main(String[] args) {

        System.out.println(longestK("aabacbebebe", 3));
    }

    static int longestK(String s, int k) {
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
            if (uniqueCharSize == k) {
                int window = j - i + 1;
                if (window > result) {
                    result = window;
                }
            } else if(uniqueCharSize > k){
                while (temp.keySet().size() != k) {
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
