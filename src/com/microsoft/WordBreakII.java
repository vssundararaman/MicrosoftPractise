package com.microsoft;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {

        String s = "catsanddog";

        String[] wordDict1 = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList (Arrays.asList(wordDict1));

        Set<String> wordDictionary = new HashSet<> (Arrays.asList(wordDict1));

        System.out.println (wordBreak (s,new ArrayList<String> (wordDict)));
        System.out.println (wordBreak1 (s,wordDictionary));
    }

    static List<String> wordBreak(String string, List<String> wordDict) {
        return wordBreakHelper (string, wordDict);

    }

    static List<String> wordBreak1(String string, Set<String> wordDict){
        return DFS(string, wordDict, new HashMap<String, LinkedList<String>>());
    }

    static List<String> wordBreakHelper(String string, List<String> wordDict) {
        List<String> results = new ArrayList<> ();

        if (string.length () == 0) {
            results.add ("");
            return results;
        }

        for (String word : wordDict) {
            if (string.startsWith (word)) {
                String sub = string.substring (word.length ());
                List<String> subStrings = wordBreakHelper (sub, wordDict);

                for (String subString : subStrings) {
                    String optionalSpace = subString.isEmpty () ? "" : " ";
                    results.add (word + optionalSpace + subString);
                }
            }
        }


        return results;
    }

    static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map){
        if(map.containsKey (s)){
            return map.get (s);
        }

        LinkedList<String> result = new LinkedList<> ();
        if(s.length ()==0){
            result.add ("");
            return  result;
        }

        for(String word: wordDict){
            if(s.startsWith (word)){
                List<String>subList = DFS (s.substring (word.length ()),wordDict,map);
                for(String sub: subList){
                    result.add (word + (sub.isEmpty ()? "" : " ") + sub);
                }
            }
        }
        map.put(s,result);
        return result;
    }
}
