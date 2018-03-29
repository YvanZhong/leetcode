package wangyi;

import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }
        int road = sc.nextInt();
        int targetH = sc.nextInt();
        int targetM = sc.nextInt();

        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
//            int tmpM = m[i] + road;
//            int tmpH = h[i];
//            if (tmpM >= 60) {
//                tmpM %= 60;
//                tmpH++;
//            }
//            if (tmpH > targetH || tmpH == targetH && tmpM > targetM) {
//                System.out.println(h[i - 1] + " " + m[i - 1]);
//                return;
//            }
            int sub = targetH * 60 + targetM - h[i] * 60 - road - m[i];
            if (sub >= 0 && min > sub) {
                res[0] = h[i];
                res[1] = m[i];
                min = sub;
            }
        }

        System.out.println(res[0] + " " + res[1]);

    }

}
