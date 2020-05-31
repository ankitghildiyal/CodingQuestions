package com.aghildiyal;

import java.util.Arrays;

public class ZeroMatrix {

    public void setZeroes(int[][] matrix) {

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for(int c=0; c < matrix[0].length; c++ ){
            if(matrix[0][c] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        for(int r=0; r < matrix.length; r++ ){
            if(matrix[r][0] == 0){
                firstColumnHasZero = true;
                break;
            }
        }

        for(int r = 1; r < matrix.length; r++){
            for(int c=1; c < matrix[0].length; c++){
                if(matrix[r][c] == 0 ){
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for(int r = 1; r < matrix.length; r++){
            if(matrix[r][0] == 0){
                for(int c = 0; c < matrix[0].length; c++){
                    matrix[r][c] = 0;
                }
            }
        }

        for(int c = 1; c < matrix[0].length; c++){
            if(matrix[0][c] == 0){
                for(int r = 0; r < matrix.length; r++){
                    matrix[r][c] = 0;
                }
            }
        }

        if(firstRowHasZero){
            for(int c = 0; c < matrix[0].length; c++){
                matrix[0][c] = 0;
            }
        }

        if(firstColumnHasZero){
            for(int r = 0; r < matrix.length; r++){
                matrix[r][0] = 0;
            }
        }
    }


}
