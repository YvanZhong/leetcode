package leetcode_2;

import java.util.*;

//尽量把之前做过的题目回顾一下
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //2
    public ListNode addTwoNumbers(ListNode ln1, ListNode ln2) {
        ListNode head = null, node = null;
        int carry = 0;
        head = node = new ListNode(0);

        while (ln1 != null || ln2 != null || carry != 0) {
            int sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            node = node.next = new ListNode(remainder);
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }

    //atoi
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            //System.out.println(Integer.MAX_VALUE %10 + " " + digit);
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    //9
    public boolean IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }



    //312 气球
    public int maxCoins(int[] nums) {
        List<Integer> list = new LinkedList();

        return 0;
    }

    //10
    public boolean isMatch1(String s, String p) {
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int i, String p, int j) {
        System.out.println(i + " " + j);
        if (i >= s.length() && j >= p.length()) {
            return true;
        } else if (i >= s.length() || j >= p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') return match(s, i, p, j + 2);
            return false;
        } else {
            char c1 = s.charAt(i);
            char c2 = p.charAt(j);
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                if (c1 == c2 || c2 == '.') {
                    return match(s, i + 1, p, j) || match(s, i, p, j + 2);
                } else {
                    return match(s, i, p, j + 2);
                }
            } else {
                if (c1 == c2 || c2 == '.') {
                    return match(s, i + 1, p, j + 1);
                } else {
                    return false;
                }
            }
        }
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public void computer (int K, int X, int A, int Y, int B) {
        int sum = 0;
        int min = (A>B)?B:A;
        int max = (A>B)?A:B;
        ///if (K > min * X)
        ///dfs (K, A, B);

    }

    public static String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) return "";

        HashMap<Character, Integer> countMap = new HashMap();
        // HashMap<Character, Integer> indexMap = new HashMap();
        for (Character ch: t.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            // indexMap.put(ch, -1);
        }

        int left = 0, right = 0;
        String res = s+"a";
        int min = s.length() + 1;
        int begin = 0;
        int count = countMap.size();
        while (right < s.length()) {
            char ch = s.charAt(right);
            /*if (indexMap.contains(ch)) {
                if (indexMap.get(ch) < left) {
                    indexMap.put(ch, right);
                }
            }*/
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) - 1);
                if (countMap.get(ch) == 0) {
                    //countMap.remove(ch);
                    count--;
                }
            }
            while (count == 0) {
                if (right - left + 1 < min) {
                    begin = left;
                    min = right - left + 1;
                }
                char tmp = s.charAt(left++);
                if (countMap.containsKey(tmp)) {
                    countMap.put(tmp, countMap.get(tmp) + 1);
                    if (countMap.get(tmp) == 1) count++;
                }
            }

            right++;
        }

        if (min > s.length()) return "";

        return s.substring(begin, begin + min);

    }

    public String minWindow2(String s, String t) {
        if(s==null||t==null||s.length()<t.length()) return "";
        int[] map = new int[256];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for(char c : tArr) map[c]++;

        int left = 0;
        int min = s.length()+1;
        int minLeft = 0;
        int count = t.length();
        for(int right = 0; right < s.length(); right++){
            char rightC = sArr[right];
            if(map[rightC]>0) count--;
            map[rightC]--;
            while(count == 0){
                if(right-left+1<min){
                    min = right-left+1;
                    minLeft = left;
                }
                char leftC = sArr[left];
                map[leftC]++;
                if(map[leftC]>0) count++;
                left++;
            }
        }
        if(minLeft+min > s.length()) return "";
        return s.substring(minLeft,minLeft+min);
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[hi]) {
                hi -= 1;
            } else if (nums[mid] > nums[hi]) {
                if (target <= nums[hi] || target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        return false;
    }

    public static int largestRectangleArea1(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, n);

        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n;){
                if(heights[j] < heights[i]){
                    nextSmaller[i] = j;
                    break;
                } else {
                    if(nextSmaller[j] == n) break;
                    else j = nextSmaller[j];
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0;){
                if(heights[j] < heights[i]){
                    prevSmaller[i] = j;
                    break;
                } else {
                    if(prevSmaller[j] == -1) break;
                    else j = prevSmaller[j];
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }
        return res;
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        backtrack(s, 0, 1, res, "");
        return res;
    }

    private static void backtrack(String s, int index, int count, List<String> res, String cur) {
        if (count == 4) {
            String str = s.substring(index);
            if (str.length() == 1 || str.length() > 1 && str.charAt(0) != '0' && Integer.valueOf(str) <= 255) {
                cur = cur + "." + str;
                res.add(cur.substring(1));
            }
        } else {
            if (index < s.length() - 1) {
                backtrack(s, index + 1, count + 1, res, cur + "." + s.substring(index, index + 1));
            }
            if (index < s.length() - 2) {
                backtrack(s, index + 2, count + 1, res, cur + "." + s.substring(index, index + 2));
            }
            if (index < s.length() - 3) {
                String str = s.substring(index, index + 3);
                if (Integer.valueOf(str) <= 255 && Integer.valueOf(str) >= 100)
                    backtrack(s, index + 3, count + 1, res, cur + "." + str);
            }
        }
    }

    private static int count = 0;

    public static boolean is_Interleave(String s1,int i,String s2,int j,String res,String s3)
    {
        count++;
        System.out.println(count);
        if(res.equals(s3) && i==s1.length() && j==s2.length())
            return true;
        boolean ans=false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i + j))
            ans|=is_Interleave(s1,i+1,s2,j,res+s1.charAt(i),s3);
        if(j<s2.length() && s2.charAt(j) == s3.charAt(i + j))
            ans|=is_Interleave(s1,i,s2,j+1,res+s2.charAt(j),s3);
        return ans;

    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return is_Interleave(s1,0,s2,0,"",s3);
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }

    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = new ListNode(0);
        //head2.next = slow;
        //reverse
        ListNode cur = slow.next, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = next;
        }

        head2 = head2.next;



        /*while (head.next != slow) {
            next = head.next;
            head.next = head2;
            ListNode next2 = head2.next;
            head2.next = next;
            head = next;
            head2 = next2;
        }*/


        ListNode p = head;
        ListNode q = head2;
        ListNode qNext = null;
        slow.next = null;
        while (q != null) {
            //System.out.println()
            qNext = q.next;
            q.next = p.next;
            p.next = q;
            q = qNext;
            p = p.next.next;
        }

//        if (!(qNext != null && qNext.next != null)) qNext.next = null;


    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    ///private void dfs (int K, int A, int )
    public static void main(String[] args) {
        System.out.println(gcd(0, 1));
        System.out.println(gcd(0, 2));
        System.out.println(gcd(1, 0));
        System.out.println(gcd(2, 0));
        /*ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }*/
//        System.out.println(isInterleave("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb",
//                "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc",
//                "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"));
//        System.out.println(restoreIpAddresses("25525511135"));
//        System.out.println(largestRectangleArea(new int[]{2,3,4}));
//        System.out.println(search(new int[]{1,3}, 3));
//        System.out.println(minWindow("aa", "aa"));
//        System.out.println(new Solution().myAtoi("-2147483647"));
        //System.out.println(new Solution().isMatch1("bccbbabcaccacbcacaa", ".*b.*c*.*.*.c*a*.c"));
        /*Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int A = in.nextInt();
        int X = in.nextInt();
        int B = in.nextInt();
        int Y = in.nextInt();
        long res = 0;
        for(int i = 1;i <= X;i++){
            for(int j= 1;j <= Y;j++){
                if(i * A + j * B == K)
                    res = res % 1000000007 +(zuhe(X,i)*zuhe(Y,j));
            }
        }
        System.out.println(res);*/
    }
    public static Long zuhe(int n,int k){
        long res = 1;
        if(n / k <= 1)
            k = n-k;
        for(int i = n-k+1, j = 1;i <= n;i++){
            res *= i;
            res /= j++;
            res = res % 1000000007;
            System.out.println(res);
        }
//        for(int i = k;i > 1;i--){
//            res = res / i;
//            System.out.println("fenzi:" + res);
//        }
        return res ;

    }


}
