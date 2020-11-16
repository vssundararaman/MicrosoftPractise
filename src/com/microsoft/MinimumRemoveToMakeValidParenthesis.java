package com.microsoft;

public class MinimumRemoveToMakeValidParenthesis {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println (minimumRemoveToMakeValidParenthesis (s));
    }

    static String minimumRemoveToMakeValidParenthesis(String string) {
        StringBuilder sb = new StringBuilder ();
        int open = 0;

        for (char ch : string.toCharArray ()) {
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append (ch);
        }

        StringBuilder result = new StringBuilder ();

        for (int i = sb.length () - 1; i >= 0; i--) {
            if (sb.charAt (i) == '(' && open-- > 0) continue;
            result.append (sb.charAt (i));
        }

        return result.reverse ().toString ();
    }
}
