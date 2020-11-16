package com.microsoft;

//TODO: NEED TO COMPLETE THIS
public class StrongPasswordChecker {

    public static void main(String[] args) {

    }


    static int strongPwdChecker(String string){

        char[] chars = string.toCharArray ();
        boolean isUpper = false, isLower = false, isDigit = false;
        int missingType = 3;

        for(char c: chars){
            if(!isUpper && Character.isUpperCase (c)){
                isUpper = true;
                missingType = missingType - 1;
            }
            if(!isLower && Character.isLowerCase (c)){
                isLower = true;
                missingType = missingType -1;
            }
            if(!isDigit && Character.isDigit (c)){
                isDigit = true;
                missingType = missingType -1;
            }
        }


        int totalChangeCnt =0, oneChangeCnt = 0, twoChangeCnt = 0, pos = 2;

        while (pos < string.length ()){
            if(chars[pos] == chars[pos-1] && chars[pos-1]==chars[pos-2] && chars[pos-2] == chars[pos]){

                int length = 2;
                while (pos< string.length () && chars[pos]==chars[pos-1]){
                    length +=1; pos +=1;
                }

                totalChangeCnt += length/3;

                if(length%3==0){
                 oneChangeCnt +=1;
                }else if(length%3==1){
                    twoChangeCnt +=1;
                }
            }else{
                pos+=1;
            }
        }

        if(string.length ()<6){
            return Math.max(missingType,6- string.length ());
        }else if(string.length () <=20){
            return Math.max (missingType, totalChangeCnt);
        }else{

            int deleteCount = string.length ()-20;
            totalChangeCnt -= Math.min(deleteCount,oneChangeCnt*1)/1;
            totalChangeCnt -= Math.min(Math.max(deleteCount - oneChangeCnt, 0), twoChangeCnt * 2) / 2;
            totalChangeCnt -= Math.max(deleteCount - oneChangeCnt - 2 * twoChangeCnt, 0) / 3;


            return deleteCount + Math.max(missingType, totalChangeCnt);
        }

    }

/*    static int strongPasswordChecker(String s) {

        if (s.length () < 5) return 6 - s.length ();
        if (s.length () == 5) return isAllCharacter (s) ? 2 : 1;

        int minDeletion = Math.max (0, s.length () - 20);
        int minReplace = callMinReplace (s);

        int[] res  = new int[]{Integer.MAX_VALUE};

        helper(0,0,0, minReplace, minDeletion,s,res);

        return res[0];
    }

    private static void helper(int start, int replace, int delete, int minReplace, int minDeletion, String s, int[] res) {


    }

    private static int callMinReplace(String s) {

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        int result = 0;

        for (char c : s.toCharArray ()) {
            if (c >= 'A' && c <= 'Z') hasUpperCase = true;
            if (c >= 'a' && c <= 'z') hasLowerCase = true;
            if (c >= '0' && c <= '9') hasDigit = true;
        }

        result += hasUpperCase ? 0 : 1;
        result += hasLowerCase ? 0 : 1;
        result += hasDigit ? 0 : 1;

        return result;
    }

    private static boolean isAllCharacter(String s) {
        char c = s.charAt (0);
        for (int i = 1; i < s.length (); i++) {
            if (s.charAt (i) != c) return false;
        }
        return true;
    }*/
}
