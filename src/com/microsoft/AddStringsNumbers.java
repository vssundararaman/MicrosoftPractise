package com.microsoft;

public class AddStringsNumbers {

    public static void main(String[] args) {

        String number1 = "32";
        String number2 = "44";

        System.out.println (addString (number1,number2));
    }

    static String addString(String number1, String number2) {

        StringBuilder sb = new StringBuilder ();

        int carry = 0;
        int p1 = number1.length ()-1;
        int p2 = number2.length ()-1;

        while ((p1 >= 0 || p2 >= 0)) {
            int x1 = p1 >= 0 ? number1.charAt (p1) - '0' : 0;
            int x2 = p2 >= 0 ? number2.charAt (p2) - '0' : 0;

            int sum = (x1 + x2 + carry) % 10;

            carry = (x1 + x2 + carry) / 10;

            sb.append (sum);
            p1--;
            p2--;
        }

        if(carry !=0){
            sb.append (carry);
        }

        return sb.reverse ().toString ();
    }
}
