package com.aghildiyal;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem - Given a NXN matrix rotate it by 90 degrees.
 * This problem is also called rotate image.
 */
public class RotateMatrix {

    public static int[][] rotate(int[][] matrix) {

        int length = matrix.length;

        //Transposing the matrix
        for(int i=0 ; i< length; i++){
            for(int j=i; j< length; j++){
                if(j!=i){
                    int holder = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = holder;
                }
            }
        }
        //Swapping the last column with the first one and then moving inwards
        //and doing the same till reach the middle
        for(int i=0; i< length; i++){
            for(int j=0,k=length-1; j<=(length/2)-1; j++,k--){
                int holder = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = holder;
            }
        }
        return matrix;

    }

    public static void main(String[] d){
        test();
    }

    private static boolean test() {
        int[][] input = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] expected = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};

        int[][] result = rotate(input);
        if(!equals(result,expected)){
            System.out.println("Test Failure." );
            return false;
        }

        return true;
    }

    public static  boolean equals(final int[][] a, final int[][] b) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; ++i) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }

        return true;
    }

}
