package com.microsoft;

public class ZigZagConversion {

    public static void main(String[] args) {

        String str = "PAYPALISHIRING";

        System.out.println (convert (str,3));
    }

    static String convert(String string, int nRows){
        if(string ==null || string.length ()==0){
            return "";
        }

        char[] ch = string.toCharArray ();
        int length = ch.length;

        StringBuffer[] sb = new StringBuffer[nRows];

        for(int i=0; i< sb.length;i++){
            sb[i] = new StringBuffer ();
        }

        int i = 0;

        while (i < length){
            for(int idx = 0; idx < nRows && i < length; idx++){
                sb[idx].append (ch[i++]);
            }
            for(int idx = nRows - 2; idx >=1 && i < length;idx--){
                sb[idx].append (ch[i++]);
            }
        }

        for(int idx = 1; idx <sb.length ; idx++){
            sb[0].append (sb[idx]);
        }

        return sb[0].toString ();
    }
}
