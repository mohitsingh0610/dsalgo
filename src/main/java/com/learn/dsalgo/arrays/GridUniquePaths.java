package com.learn.dsalgo.arrays;

/**
 * Given a matrix m X n, count paths from left-top to the right bottom of a
 * matrix with the constraints that from each cell you can either only move to the rightward direction or the downward direction.
 * Input Format: m = 2, n= 2
 * Output: 2
 */
public class GridUniquePaths {

    public static void main(String[] args){

        System.out.println(uniquePaths(1,7,1,3));
    }
    
    //using combination
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
            int r = m - 1; 
            double res = 1;
            
            for (int i = 1; i <= r; i++)
                res = res * (N - r + i) / i;
            return (int)res;
    }

    private static int uniquePaths(int sc, int dc, int sr, int dr){
        if(sc == dc && sr == dr){
            return 1;
        }
        int result1 = 0;
        int result2 = 0;
        if(sr < dr){
            result1 = uniquePaths( sc,  dc,  sr + 1,  dr);
        }
        if(sc < dc){
            result2 = uniquePaths( sc+1,  dc,  sr,  dr);
        }
        return result1 + result2;
    }


    
}
