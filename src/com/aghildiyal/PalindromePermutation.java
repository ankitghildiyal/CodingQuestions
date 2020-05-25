package com.aghildiyal;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem - Given a string determine if the string is a permutation of
 * a palindrome. Eg - TactCoa
 */
public class PalindromePermutation {


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

    public static void main(String[] s){
        if(testPass()){
            System.out.println("Tests passed");
        }
    }

    private static boolean testPass() {
        Map<String,Boolean> testData = new HashMap<>();
        testData.put("tact coa",true);
        testData.put("abcdef",false);
        testData.put("abcdxdcba",true);

        for(Map.Entry<String,Boolean> entry : testData.entrySet()){
            String input = entry.getKey();
            Boolean expected = entry.getValue();
            Boolean result = isPalindromePermutation(input);
            if(!result.equals(expected)){
                System.out.println("Test Failure. Input : " + input +  " Expected : " + expected + "  Actual : " + result );
                return false;
            }
        }

        return true;
    }
}
