package com.aghildiyal;

public class BinarySearch {

    public static void main(String[] f){
        Comparable[] a = new Comparable[]{10,15,80,100,121,130,191, 194};
        Integer result = search(a, 80, 0, a.length-1);
        if(result == null){
            System.out.println("not found");
        }else{

            System.out.println("found at index: " + result);
        }
    }

    private static Integer search(Comparable[] a, Comparable toSearch, int lo, int hi) {
        if(lo == hi) return null;

        int mid = lo + (hi-lo)/2;
        if(a[mid] == toSearch){
            return mid;
        }else if( a[mid].compareTo(toSearch) > 0){
            return search(a, toSearch, lo, mid);
        }else{
            return search(a, toSearch, mid+1, hi);
        }
    }
}
