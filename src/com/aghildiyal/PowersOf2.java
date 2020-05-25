package com.aghildiyal;


/**
 * Given an integer print all powers of 2 less than the number
 */
public class PowersOf2 {

    public static void main(String[] d){

        int n = 10;
        powerOf2(n);
    }

    public static int powerOf2(int n){
        if(n < 0){
            return 0;
        }if(n == 1){
            System.out.println(1);
            return 1;
        }else{
            int prev = powerOf2(n/2);
            int current = prev*2;
            System.out.println(current);
            return current;
        }
    }

}
