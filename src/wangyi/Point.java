package wangyi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Point {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Map<Integer, Integer> map = new HashMap<>();

        String[] strArray = str.split(" ");

        for (String s: strArray) {
            int val = Integer.valueOf(s);
            map.put(val, map.getOrDefault(val, 0) + val);
        }

        int[] a = new int[map.size()];

        int i = 0;
        for (int n: map.keySet()) {
            a[i++] = n;
        }

        if (a.length == 0) {
            System.out.println(0);
            return;
        }

        if (a.length == 1) {
            System.out.println(map.get(a[0]));
            return;
        }

        int[] dp = new int[a.length];

        Arrays.sort(a);
        dp[0] = map.get(a[0]);
        if (a[1] == a[0] + 1) {
            dp[1] = map.get(a[1]);
        } else {
            dp[1] = dp[0] + map.get(a[1]);
        }

        //System.out.println(map);
        for (i = 2; i < dp.length; i++) {
            if (a[i - 1] == a[i] - 1) {
                dp[i] = dp[i - 2] + map.get(a[i]);
            } else {
                dp[i] = dp[i - 1] + map.get(a[i]);
            }
        }

        System.out.println(Math.max(dp[dp.length - 1], dp[dp.length - 2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Map<Integer, Integer> map = new HashMap<>();

        String[] strArray = str.split(" ");

        for (String s: strArray) {
            int val = Integer.valueOf(s);
            map.put(val, map.getOrDefault(val, 0) + val);
        }

        int[] a = new int[map.size()];

        int i = 0;
        for (int n: map.keySet()) {
            a[i++] = n;
        }
        if (a.length == 0) {
            System.out.println(0);
            return;
        }

        if (a.length == 1) {
            System.out.println(map.get(a[0]));
            return;
        }

        int[] dp = new int[a.length];

        Arrays.sort(a);

        int[] notget = new int[a.length];
        int[] get = new int[a.length];

        get[0] = map.get(a[0]);
        notget[1] = get[0];
        if (a[1] == a[0] + 1) {
            get[1] = map.get(a[1]);
        } else {
            get[1] = get[0] + map.get(a[1]);
        }

        for (i = 2; i < get.length; i++) {
            notget[i] = Math.max(notget[i - 1], get[i - 1]);
            if (a[i - 1] == a[i] - 1) {
                get[i] = Math.max(notget[i - 1] + map.get(a[i]), get[i - 2]);
            } else {
                get[i] = Math.max(notget[i - 1], get[i - 1]) + map.get(a[i]);
            }
        }

        System.out.println(Math.max(notget[dp.length - 1], get[dp.length - 1]));

    }

}
