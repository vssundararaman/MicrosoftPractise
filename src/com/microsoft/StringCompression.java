package com.microsoft;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};

        System.out.println (compress (chars));
    }

    static int compress(char[] chars){

        if(chars == null || chars.length ==0){
            return 0;
        }

        int index = 0, i = 0, j = 0, n = chars.length;

        while(i<n){

            char ch = chars[i];
            j = i;

            while(j<n && chars[i] == chars[j]){
                j++;
            }

            int freq = j - i;
            chars[index++] = ch;

            if(freq == 1){

            }else if(freq < 10){
                chars[index++] = (char)(freq + '0');
            }else{
                String strFreq = String.valueOf (freq);
                for(char chFreq : strFreq.toCharArray ()){
                    chars[index++] = chFreq;
                }
            }

            i = j;
        }
        return index;
    }
}
