package com.aghildiyal;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem - Perform string compression using counts of repeated characters.
 * However, if the length of compressed string and original string is same
 * return the original string;
 * E.g, input - abbbbbbffffffc output - a1b6f6c1
 * input abcdef output - abcdef
 *
 */
public class StringCompression {



    public static String compressString(String s){
        char[] chars = s.toCharArray();
        int compressedLength = compressedLength(chars);
        if(compressedLength >= s.length() ){
            return s;
        }
        StringBuilder compressedString = new StringBuilder(compressedLength);
        int occurrenceCount = 0;


        for(int i=0; i < s.length(); i++){
            occurrenceCount++;
            if((i+1) <= chars.length-1 && chars[i] != chars[i+1] ){
                compressedString.append(chars[i]).append(occurrenceCount);
                occurrenceCount = 0;
            }else if(i == chars.length-1){
                compressedString.append(chars[i]).append(occurrenceCount);
            }
        }
        return compressedString.toString();
    }

    public static int compressedLength(char[] chars){
        int finalCount = 1;
        for(int i=0; i < chars.length; i++){
            if((i+1) <= chars.length-1 && chars[i] != chars[i+1] ){
                finalCount = finalCount + 2;
            } else if(i==chars.length-1 ){
                finalCount+=1;
            }
        }
        return finalCount;
    }

    public static void main(String[] s){
        if(testPass()){
            System.out.println("Tests passed");
        }
    }

    private static boolean testPass() {
        Map<String,String> testData = new HashMap<>();
        testData.put("abbbbbbffffffc","a1b6f6c1");
        testData.put("abcdef","abcdef");

        for(Map.Entry<String,String> entry : testData.entrySet()){
            String input = entry.getKey();
            String expected = entry.getValue();
            String result = compressString(input);
            if(!result.equals(expected)){
                System.out.println("Test Failure. Input : " + input +  " Expected : " + expected + "  Actual : " + result );
                return false;
            }
        }

        return true;
    }
}

