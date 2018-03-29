package wangyi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Job {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n];
        int[] p = new int[n];
        int[] f = new int[m];
        Integer[] f2 = new Integer[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            f[i] = sc.nextInt();
            f2[i] = f[i];
        }

        Arrays.sort(f2, Collections.reverseOrder());
        //Collections.reverseOrder(f2::);
        //Arrays.sort(f2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m && f2[j] >= d[i]; j++) {
                //if (f2[j] >= d[i])
                    map.put(f2[j], Math.max(map.getOrDefault(f2[j], 0), p[i]));
            }
        }

        for (int cap: f) {
            System.out.println(map.get(cap));
        }



    }

}
