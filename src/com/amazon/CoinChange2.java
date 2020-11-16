package com.amazon;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println (coinChange (amount,coins));
    }

    static int coinChange(int amount, int[] coins){
        int[] arr = new int[amount+1];
        Arrays.fill (arr,0);

        arr[0] = 1;

        for(int c: coins){
            for(int i=c;i<= amount; i++){
                arr[i] += arr[i-c];
            }
        }

        return arr[amount];
    }
}
