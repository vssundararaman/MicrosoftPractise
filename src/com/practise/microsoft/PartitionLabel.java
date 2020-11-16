package com.practise.microsoft;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {

    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";
        System.out.println (partitionLabel (s));
    }

    static List<Integer> partitionLabel(String s){

        if(s == null || s.length ()==0){
            return null;
        }

        int[] lastIndeces = new int[26];

        List<Integer> outputArray = new ArrayList<> ();

        for(int i=0;i<s.length ();i++){
            lastIndeces[s.charAt (i)-'a'] = i;
        }

        int start = 0;
        int end = 0;

        for(int i=0;i<s.length ();i++){
            end = Math.max (end, lastIndeces[s.charAt (i)-'a']);

            if(i == end){
                outputArray.add (end-start+1);
                start = end+1;
            }
        }

        return outputArray;
    }
}
