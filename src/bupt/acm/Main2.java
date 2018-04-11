package bupt.acm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int count = scanner.nextInt();
        while (count > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Map<Integer, Integer> prims = countPrim(x);

            long total = 1;
            int mod = 1000000007;

            for (int n: prims.keySet()) {
                total *= helper(prims.get(n), y);
                total %= mod;
            }


//            System.out.println((total * (double)(myPow(2, y - 1))) % mod);
            System.out.println(total);

            System.out.println(helper2(x, y));

            count--;
        }
    }

    public static double myPow(double x, int n) {
        double ans = 1;
        int mod = 1000000007;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) {
                ans *= x;
                ans %= mod;
            }
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }


    public static long helper(int n, int y) {
        int begin = n + y - 1;
        int end = y - 1;
        int mod = 1000000007;
        long tmp = 1;
        while (begin > end) {
            tmp = ((tmp) * (begin)) % mod;
            begin--;
        }

        while (n > 1) {
            tmp /= n;
            tmp %= mod;
            n--;
        }
        return tmp;
    }

    private static HashMap<Integer, Integer> countPrim(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            while (n % i == 0) {
                count++;
                total++;
                n = n / i;
            }
            map.put(i, count);
        }
        System.out.println(total);
        return map;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        System.out.println(helper(4, 2));
        while (count > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(helper(x, y));
            count--;
        }
    }

    private static double helper2(int x, int y) {
        double[] dp = new double[x + 1];
        double[] dp2 = new double[x + 1];
        int mod = 1000000007;
        for (int i = 1; i <= x; i++) {
            dp[i] = 1;
        }

        for (int j = 0; j < y - 1; j++) {
            for (int z = 1; z <= x; z++) {
                dp2[z] = dp[z];
            }

            for (int i = 1; i <= x; i++) {
                for (int z = 2; z * i <= x; z++) {
                    dp[z * i] = (dp[z * i] % mod + dp2[i] % mod) % mod;
                }
            }
        }

//        return (dp[x] * (Math.pow(2, y - 1) % mod)) % mod;
        return dp[x];
    }

}
