package com.learn.dsalgo.arrays;
/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
public class SetMatrixToZero {
    
    public static void main(String[] args){
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(matrix);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                                   + matrix[i][j]);
    }
    

    static void setZeros(int[][] matrix){
        int col = matrix[0].length - 1;
        int row = matrix.length -1 ;
        // Since we are using first column and first row for calcuation to reduce the time complexity, we need extra space for keeping first row calculation
        // If we dont do this there would overlapping for a[0][0] position. The a[0][0] would be used for first column calculation.
        boolean rowZero = Boolean.FALSE;

        //Determine which row and column needs to be zeroed out
        for(int i= 0 ; i <= row; i++){
            for(int j= 0 ; j <= col; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    if(i > 0){
                        matrix[i][0] = 0;
                    }else{
                        rowZero = Boolean.TRUE;
                    }
                }
            }  
        }

        for(int i= 1 ; i <= row; i++){
            for(int j= 1 ; j <= col; j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                           matrix[i][j] = 0;
                    }
            }
        }

        if(matrix[0][0] == 0){
           for(int i =0; i<= row; i++){
               matrix[i][0] = 0;
           }
        }

        if(rowZero){
            for(int j =0; j<= col; j++){
                matrix[0][j] = 0;
            }
         }
    }
}
