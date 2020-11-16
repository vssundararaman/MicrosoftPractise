package com.microsoft;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] string = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println (alienOrder (string));
    }

    static String alienOrder(String[] words) {
        int[] inDegree = new int[26];

        Map<Character, List<Character>> graph = new HashMap ();

        for (String word : words) {
            for (char c : word.toCharArray ()) {
                graph.put (c, new ArrayList<> ());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String start = words[i];
            String end = words[i + 1];

            if (start.length () > end.length () && start.startsWith (end)) {
                return "";
            }
            int len = Math.min (start.length (), end.length ());

            for (int j = 0; j < len; j++) {
                char out = start.charAt (j);
                char in = end.charAt (j);

                if (out != in) {
                    graph.get (out).add (in);

                    inDegree[(int) in - 'a']++;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder ();
        Queue<Character> queue = new LinkedList<> ();

        for (char ch : graph.keySet ()) {
            if (inDegree[(int) ch - 'a'] == 0) {
                queue.add (ch);
            }
        }

        while (!queue.isEmpty ()) {
            char out = queue.poll ();
            sb.append (out);
            for (char in : graph.get (out)) {
                if (--inDegree[(int) in - 'a'] == 0) {
                    queue.add (in);
                }
            }
        }

        return sb.length () == graph.size () ? sb.toString () : "";
    }

}
