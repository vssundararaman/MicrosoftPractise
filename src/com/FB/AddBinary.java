package com.FB;

public class AddBinary {

    public static void main(String[] args) {

        String a = "11", b = "1";
        System.out.println (addBinary (a,b));
        a = "1010"; b= "1011";
        System.out.println (addBinary (a,b));
    }

    static String addBinary(String string1, String string2){
        StringBuilder sb = new StringBuilder ();
        int i = string1.length ()-1;
        int j=string2.length ()-1;
        int carry = 0;

        while(i>=0 || j>=0){
            int sum = carry;

            if(i>=0){
                sum += string1.charAt (i--)-'0';
            }

            if(j>=0){
                sum+= string2.charAt (j--)-'0';
            }
            sb.insert (0,sum % 2);
            carry = sum/2;
        }

        if(carry > 0){
            sb.insert (0,1);
        }

        return sb.toString ();
    }
}
