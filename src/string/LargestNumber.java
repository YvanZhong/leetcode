package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    //[0,0] return 0
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>(){
            public int compare(String a, String b) {
                String s1 =  a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strs, comparator);
        if (strs[0].equals("0")) { // head = 0
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        /*int i = 0;
        for (; i < sb.length() - 1 && sb.charAt(i) == '0'; i++) {
        } //remove head 0
        return sb.delete(0, i).toString();*/

        return sb.toString();
    }

}
