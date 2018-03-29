package dynamicProgramming;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak1(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                count++;
                if (dp[j] && dict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break; //must
                }
            }
        }

        return dp[s.length()];

    }

    public static int count = 0;
    private static Map<String, Boolean> map = new HashMap<>();

    public static boolean wordBreak(String s, Set<String> dict) {
        if (map.containsKey(s)) {
//            System.out.println("yes");
            return map.get(s);
        }
        boolean flag = false;
//        for (int j = 0; j < s.length(); j++) {
        for (int j = s.length() - 1; j >= 0; j--) {
            count++;
            if (dict.contains(s.substring(j, s.length()))){
                map.put(s.substring(j, s.length()), true);
                if (j == 0 || wordBreak(s.substring(0, j), dict)) {
                    map.put(s, true);
                    return true;
                }
            } else {
                map.put(s.substring(j, s.length()), false);
            }

        }
        map.put(s, flag);
        return flag;

    }
    /*
    * public static boolean wordBreak(String s, List<String> list) {
        Set<String> dict = new HashSet();
        dict.addAll(list);
        Map<String, Boolean> map = new HashMap<>();

        return wordBreak2(s, dict, map);
    }

    public static boolean wordBreak2(String s, Set<String> dict,Map<String, Boolean> map ) {
        if (map.containsKey(s)) return map.get(s);
        System.out.println(s);
        boolean flag = false;
        for (int j = 0; j < s.length(); j++) {
                if (dict.contains(s.substring(0, j + 1)) && (j + 1 == s.length() || wordBreak2(s.substring(j + 1), dict, map))) {
                    map.put(s, true);
                    return true;
                }
            }
        return flag;

    }*/

    public static void main(String... args) {
        Set<String> set = new HashSet<>();
        set.add("aaaa");
        set.add("aaaaa");
        set.add("aaaaaa");
        set.add("aaaaaaa");
        set.add("aaaaaaaa");
        set.add("aaaaaaaaa");
        set.add("aaaaaaaaaa");
        set.add("aa");
        set.add("a");
        set.add("aaa");
        set.add("leet");
        set.add("code");
        String str1 = "leetcode";
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//                ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

        long start = System.currentTimeMillis();
        System.out.println(wordBreak(str, set));
        //System.out.println(map);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(count);
        System.out.println(str.length());
    }


}
