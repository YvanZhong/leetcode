package dynamicProgramming;

import java.util.*;

public class WordBreakII {
    /* too slow 最后都判断了dog是不是在dict中，重复了。从前往后走会有很多路，从后往前更好？
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> rst = new ArrayList();
        if (s == null) return rst;
        helper(s, 0, dict, "", rst);
        return rst;
    }

    private static void helper(String s, int begin, Set<String> dict, String cur, ArrayList<String> rst) {
        //System.out.println("begin"+begin);
        if (begin >= s.length()) rst.add(cur);
        for (int i = begin; i < s.length(); i++) {
            String substring = s.substring(begin, i+1);
            //System.out.println(substring);
            if (dict.contains(substring)) {
                String tmp = cur + substring;
                if (i != s.length() - 1) tmp += " ";
                helper(s, i+1, dict, tmp, rst);
            }
        }
    }*/

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substr = s.substring(i, j + 1);
                if (dict.contains(substr)) {
                    dp[i][j] = 1;
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        //res.add("123");
        helper(s, s.length() - 1, dp, "", res);
        return res;
    }

    /* end to head 牛客通过 leetcode不行*/
    private static void helper(String s, int end, int[][] dp, String cur, ArrayList<String> rst) {
        //System.out.println("begin"+begin);
        if (end < 0) rst.add(cur);
        for (int i = end; i >= 0; i--) {
            //System.out.println(substring);
            if (dp[i][end] == 1) {
                String substring = s.substring(i, end + 1);
                String tmp = substring + cur;
                if (i != 0) tmp = " " + tmp;
                helper(s, i - 1, dp, tmp, rst);
            }
        }
    }

    //leetcode 使用map记忆
    public List<String> wordBreak(String s, List<String> dict) {
        Set<String> set = new HashSet();
        set.addAll(dict);
        return DFS(s, set, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        set.add("a");
//        set.add("b");
//        set.add("and");
//        set.add("dog");
//        set.add("sand");
//        ArrayList rst = wordBreak("catsanddog", set);
        ArrayList rst = wordBreak("a", set);
        System.out.println(rst);
    }
}
