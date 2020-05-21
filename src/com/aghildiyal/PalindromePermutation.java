package com.aghildiyal;


/**
 * Problem - Given a string determine if the string is a permutation of
 * a palindrome. Eg - TactCoa
 */
public class PalindromePermutation {

    public static void main(String[] s){
        String test = "tact coa";
        System.out.println(isPalindromePermutation(test));

    }

    private static boolean isPalindromePermutation(String str){
        int[] table = new int[('z'-'a')+1];
        for(char c : str.toCharArray()){
            char lcChar = Character.toLowerCase(c);
            if('a' <= lcChar && lcChar <= 'z'){
                int numericValue = lcChar - 'a';
                table[numericValue]++;
            }
        }

        boolean foundOdd = false;
        for(int i : table){
            if(i%2 != 0){
                if(!foundOdd)
                foundOdd = true;
                else
                    return false;
            }
        }
        return true;
    }
}
