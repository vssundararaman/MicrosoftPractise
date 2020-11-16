package com.microsoft;

public class ConsecutiveNumbersSum {

    public static void main(String[] args) {

        System.out.println (consecutiveNumbersSum1 (100));
        System.out.println (consecutiveNumbersSum (100));
    }

    static int consecutiveNumberSum(int N){
        int answer = 0;

        for(int i=1, n=N-1; n>=0; n-=++i){
            if((n%i) ==0) answer++;
        }

        return answer;
    }

    //Time & space Complexity O(n^0.5)

    static int consecutiveNumbersSum(int N){
        int sum = 0, ans = 0;

        for(int i=1;sum<N;i++){
            sum +=i;

            if(((N-sum) % i)==0){
                ans++;
            }
        }

        return ans;
    }

    static int consecutiveNumbersSum1(int N) {
        int res = 1, count;
        while (N % 2 == 0) N /= 2;
        for (int i = 3; i * i <= N; i += 2) {
            count = 0;
            while (N % i == 0) {
                N /= i;
                count++;
            }
            res *= count + 1;
        }
        return N == 1 ? res : res * 2;
    }
}
