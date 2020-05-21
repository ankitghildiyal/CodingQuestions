package com.aghildiyal;


/**
 * Problem - Given 2 strings check if one is permutation of other. Meaning
 * that 2 strings have the same characters arranged in different order.
 */
public class StringPermutationChecker {

    /**
     * Main.
     *
     * @param a the a
     */
    public static void main(String[] a){
        String str1 = "asdfgh";
        String str2 = "hgfdsa";

        boolean result = isPermutation(str1, str2);
        System.out.println(result);

    }

    /**
     * Sorts using array approach.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return the boolean2
     */
    public static boolean isPermutation(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        int[] charCountArray = new int[128];
        for(int i=0; i < str1.length(); i++){
            int c = str1.charAt(i);
            charCountArray[c]++;
        }

        for(int i=0; i < str2.length(); i++){
            int c = str2.charAt(i);
            charCountArray[c]--;
            if(charCountArray[c] < 0){
                return false;
            }
        }

        return true;

    }
}
