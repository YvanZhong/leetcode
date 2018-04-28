package zhaoshang;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(sell(nums));
            t--;
        }
    }

    public static int sell(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(sell(nums, 0, nums.length - 2), sell(nums, 1, nums.length - 1));
    }

    private static int sell(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}
