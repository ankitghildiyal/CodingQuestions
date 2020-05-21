package com.aghildiyal;

/*
Given a string determine if it has unique characters
 */
public class UniqueCharacterString {

    public static void main(String[] s){

        String test = "asdfghhj";
        boolean result = hasUniqueChars(test);
        System.out.println("Result with boolean array approach---->" + result);


        System.out.println("Result with bit vector approach---->" + hasUniqueChars_BitVector(test));

    }

    /*
    The method uses a boolean array of length 128.
    Time complexity - O(n)
     */
    private static boolean hasUniqueChars(String test) {
        boolean[] ascii = new boolean[128];
        for(int i=0 ; i < test.length() ; i++){
            int ch = test.charAt(i);
            if(ascii[ch]){
                return false;
            }else{
                ascii[ch] = true;
            }
        }
        return true;
    }

    private static boolean hasUniqueChars_BitVector(String test){
        int checker = 0;
        for(int i=0; i < test.length(); i++){
            int val = test.charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker = checker | (1 << val);
        }
        return true;
    }
}
