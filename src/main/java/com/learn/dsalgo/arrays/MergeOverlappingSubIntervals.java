package com.learn.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {
    
    public static void main(String[] args){
          
      //int[][] arr = {{1,3},{8,10},{15,18},{2,6}};
      int[][] arr =  {{1,4},{4,5}};
      int[][] matrix =  merge(arr);
      int m = matrix.length;
      int n = matrix[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
    }

    static int[][] merge(int[][] intervals) {

        int row = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        result.add(intervals[0]);
        int resultIdx = 0;
        for(int i= 1; i< row; i++){
            int[] temp = intervals[i];
            int[] top = result.get(resultIdx);
            if(temp[0] > top[1]){
                resultIdx++;
                result.add(resultIdx,temp);
            }else{
                if(top[1] < temp[1]){
                     top[1] = temp[1];
                }
            }
        }
        return  result.stream().toArray(int[][]::new);
    }

}
