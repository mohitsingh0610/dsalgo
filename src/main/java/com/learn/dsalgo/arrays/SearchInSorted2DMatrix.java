package com.learn.dsalgo.arrays;

/*
 * Problem Statement: Given an m*n 2D matrix and an integer, write a program to find if the given integer exists in the matrix.
 * Given matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */

public class SearchInSorted2DMatrix {

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 5;
       System.out.println(searchMatrix(matrix, target));
    }
    

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0, high = row * col ;
        return binarySearch(matrix, target, high -1 , low);

    }

    private static boolean binarySearch(int[][] matrix, int target, int high, int low){
        if(high<low){
            return false;
        }
        int mid = low + (high-low) / 2;
        int col = matrix[0].length;
        //to find the middle element indexes
        int middleElement =  matrix[mid/col][mid%col];
        if(target == middleElement){
            return Boolean.TRUE;
        }else if(target>middleElement){
            return binarySearch(matrix, target, high, mid +1);
        }else{
            return binarySearch(matrix, target, mid -1, low);
        }
    }
}

