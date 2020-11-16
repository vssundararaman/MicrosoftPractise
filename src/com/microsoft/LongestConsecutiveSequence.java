package com.microsoft;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println (findLongestConsecutiveSequence (nums));
    }

    //TimeComplexity O(N) and space Complexity O(n)
    static int findLongestConsecutiveSequence(int[] nums){
        Set<Integer> set = new HashSet<> ();

        for(int num: nums){
            set.add (num);
        }

        int result = 0;
        while(!set.isEmpty ()){
            int x = set.iterator ().next ();
            set.remove (x);

            int lowerBound = x-1;
            while(set.contains (lowerBound)){
                set.remove (lowerBound);
                lowerBound--;
            }

            int upperBound = x+1;
            while(set.contains (upperBound)){
                set.remove (upperBound);
                upperBound++;
            }

            result = Math.max (result,upperBound-lowerBound-1);
        }

        return result;
    }
}
