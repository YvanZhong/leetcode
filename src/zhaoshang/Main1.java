package zhaoshang;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = in.nextInt();
            }
            helper(coins, k);
            t--;
        }
    }

    private static void helper(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i <= target; i++) {
                dp[i] += dp[i - coins[j]];
                dp[i] %= 100000007;
            }
        }

        System.out.println(dp[target]);
    }
}
