package com.microsoft;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {10,2};

        System.out.println (largestNumber (nums));
    }

    static String largestNumber(int[] nums){
        String[] arr = new String[nums.length];

        for(int i=0; i < nums.length ; i++){
            arr[i] = String.valueOf (nums[i]);
        }

        Arrays.sort (arr, new Comparator<String> () {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo (a+b);
            }
        });

        StringBuilder sb = new StringBuilder ();
        for(String str: arr){
            sb.append(str);
        }

        while (sb.charAt (0)=='0' && sb.length ()>1){
            sb.deleteCharAt (0);
        }

        return sb.toString ();
    }
}
