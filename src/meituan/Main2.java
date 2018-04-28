package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        int[] A = new int[N + 1];
        A[1] = p;
        for (int i = 2; i < A.length; i++) {
            A[i] = (A[i - 1] + 153) % A[1];
        }

        //int t = Math.max(n, m);
        //map = new int[t+1][t+1];

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum += A[gcd(i, j)];
            }
        }
        System.out.println(sum);
    }

//    private static int[][] map;

    private static Map<String, Integer> map = new HashMap();

    private static String getKey(int a, int b) {
        if (a > b) {
            return a + "#" + b;
        } else {
            return b + "#" + a;
        }
    }

    private static int gcd(int a, int b) {
        //System.out.println(a+" "+b);
        if (map.containsKey(getKey(a, b))) return map.get(getKey(a, b));
        if (b == 0) return a;
        int rst = gcd(b, a % b);
        map.put(getKey(a, b), rst);
        return rst;
    }
}
