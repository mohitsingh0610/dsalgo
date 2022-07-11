package com.learn.dsalgo.arrays;

/*
 * Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
 * Rotate Image by 90 degree
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateMatrix {
    
    public static void main(String[] args){
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int m = matrix.length;
        int n = matrix[0].length;
        rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // transpose of matrix
        for(int i = 0; i< row; i++){
            for (int j=i+1;j< col;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row in matrix 
        for(int i = 0; i< row; i++){
            for(int k=0,j=col-1; k <= j; k++,j--){
                int temp = matrix[i][k];
                matrix[i][k] =  matrix[i][j] ;
                matrix[i][j] = temp;
            }
        }
    }
    
}
