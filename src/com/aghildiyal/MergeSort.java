package com.aghildiyal;

import java.util.Arrays;

public class MergeSort {

    public static void merge(String[] arr, String[] aux, int lo, int mid, int hi){

        for(int k = lo ; k <= hi ; k++){
            aux[k] = arr[k];
        }

        int i = lo;
        int j = mid + 1;

        for(int k=lo ; k <= hi ; k++){
            if(i > mid) arr[k] = aux[j++];
            else if(j > hi) arr[k] = aux[i++];
            else if(less(aux[i], aux[j])) arr[k] = aux[i++];
            else  arr[k] = aux[j++];
        }

    }

    public static boolean less(String a, String b){
        if(a == null){
            return true;
        }

        if(b == null){
            return false;
        }

        return a.compareTo(b) < 0;

    }

    public static void sort(String[] arr, String[] aux, int lo, int hi){

        if(hi <= lo) return ;

        int mid = lo + (hi - lo)/2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr,aux,lo,mid,hi);


    }

    public static void main(String[] f){
//        String[] toSort = new String[]{"m","e","r","g","e","s","o","r","t"};
        String[] toSort = new String[]{"a","l","g","o","r","i","t","h","m"};
        String[] aux = new String[toSort.length];
        sort(toSort, aux, 0, toSort.length-1);
        Arrays.stream(toSort).forEach(System.out::println);
    }
}
