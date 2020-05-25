package com.aghildiyal;

/**
 * Below are three solutions to popular knapSack 0-1 problem, namely
 * 1) Recusrive solution
 * 2) Resursion with memoising solution
 * 3) Bottom up Dynamic Programming
 */
public class KnapSack01 {

    /**
     * Recursive solution to the Knapsack problem.
     * Time Complexity = 2^n
     *
     * @param capacity the capacity
     * @param weights  the weights
     * @param values   the values
     * @param length   the length
     * @return the int
     */
    public static int knapSack_Recursion(int capacity, int[] weights, int[] values, int length){

        //base case
        if(capacity == 0 || length == 0 )
            return 0;
        if(capacity < weights[length-1]){
            return knapSack_Recursion(capacity, weights, values, length-1);
        }else{
            int useTheWeight = values[length-1] + knapSack_Recursion(capacity-weights[length-1], weights, values, length-1);
            int dontUseTheWeight = knapSack_Recursion(capacity, weights, values, length-1);
            int result = Math.max(useTheWeight, dontUseTheWeight);
            return result;
        }
    }

    /**
     * Knap sack dp memoisation int.
     * Time Complexity = O(nc)
     *
     * @param capacity  the capacity
     * @param weights   the weights
     * @param values    the values
     * @param length    the length
     * @param memoising the memoising
     * @return the int
     */
    public static int knapSack_DP_Memoisation(int capacity, int[] weights, int[] values, int length, int [][]memoising){

        if(memoising[capacity][length] != -1){
            return memoising[capacity][length];
        }else{
            if(capacity == 0 || length == 0 ){
                memoising[capacity][length] = 0;
                return 0;
            }
            if(capacity < weights[length-1]){
                return knapSack_DP_Memoisation(capacity, weights, values, length - 1, memoising);
            }else{
                int useTheWeight = values[length-1] + knapSack_DP_Memoisation(capacity - weights[length-1], weights, values, length - 1, memoising);
                int dontUseTheWeight = knapSack_DP_Memoisation(capacity, weights, values, length - 1, memoising);
                int result = Math.max(useTheWeight, dontUseTheWeight);
                memoising[capacity][length] = result; //The array stores result for a particular value of capacity and length
                return result;
            }
        }
    }

    /**
     * Bottom up approach for solving Knap sack 0-1 problem.
     *
     * @param capacity the capacity
     * @param weights  the weights
     * @param values   the values
     * @param length   the length
     * @return the int
     */
    public static int knapSack_BottomUp(int capacity, int[] weights, int[] values, int length){

        /*Points to note 
        1) +1 in size of array is to account for the base case,i.e, when capacity is zero or when we have zero items. 
        2) A cell in result array represents VALUE when CAPACITY was Ci and ITEMS available items j and less.*/
        int[][] result = new int[capacity+1][length+1];
        for(int capacityIndex = 0 ; capacityIndex < result.length ; capacityIndex++){
            for(int itemIndex = 0 ; itemIndex < result[capacityIndex].length ; itemIndex++){
                if(capacityIndex == 0 || itemIndex == 0){
                    result[capacityIndex][itemIndex] = 0;
                }else if( capacityIndex < weights[itemIndex-1]){//-1 is to account for 1 we added in result array for base case
                    result[capacityIndex][itemIndex] = result[capacityIndex][itemIndex-1];
               }else{
                    /*
                    1) If we use the weight then the value we get is the (value of item,i.e, values[itemIndex-1]) + value
                       when capacity was (current capacity - weight of current item) and items available were one less 
                       than the current item.  
                     */
                    int valueIfWeightUsed = values[itemIndex-1] + result[capacityIndex-weights[itemIndex-1]][itemIndex-1];
                    /*
                    If we don't use the weight then value is the value at capacity when items available were one less than
                    the current item.
                     */
                    int valueIfWeightNotUsed = result[capacityIndex][itemIndex-1];
                    result[capacityIndex][itemIndex] = Math.max(valueIfWeightUsed, valueIfWeightNotUsed);
                }
            }
        }
        return  result[capacity][length];
    }

    //tests
    public static void main(String[] s){
//        int[] weights = new int[]{10,20,30};
//        int[] values = new int[]{60,100,120};
//        int capacity = 50;

        int[] weights = new int[]{5,3,4,2};
        int[] values = new int[]{60,50,70,30};
        int capacity = 5;


//        int[] weights = new int[]{1,2,3,8,7,4};
//        int[] values = new int[]{20,5,10,40,15,25};
//        int capacity = 10;
        long startRecursive = System.currentTimeMillis();
        int result = knapSack_Recursion(capacity, weights, values, weights.length);
        long endRecursive = System.currentTimeMillis();
        System.out.println("Recursive sol -  " +  result + "  totalTime  " + (endRecursive - startRecursive));

//        int [][]memoising = new int[capacity+1][weights.length+1]; //Adding 1 for the base case
//        for(int i=0 ; i < memoising.length; i++){
//            Arrays.fill(memoising[i], -1);
//        }
//        long startDPMemo = System.currentTimeMillis();
//        int result_DPMemo= knapSack_DP_Memoisation(capacity, weights, values, weights.length, memoising);
//        long endDPMemo = System.currentTimeMillis();
//        System.out.println("DP Memo sol -  " +   result_DPMemo + "  totalTime  " + (endDPMemo - startDPMemo));

        int result_DPBottomUp = knapSack_BottomUp(capacity, weights, values, weights.length );
        System.out.println("DP BottomUp sol -  " +   result_DPBottomUp + "  totalTime  ");
    }
}
