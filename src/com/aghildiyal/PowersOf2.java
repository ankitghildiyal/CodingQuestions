package com.aghildiyal;

public class PowersOf2 {

    public static void main(String[] d){

        int n = 50;
        powerOf2(50);
    }

    public static int powerOf2(int n){
        System.out.println("n--- " + n );
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
