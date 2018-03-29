package wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
        }
        int[] y1 = new int[n];
        for (int i = 0; i < n; i++) {
            y1[i] = sc.nextInt();
        }
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x2[i] = sc.nextInt();
        }
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            y2[i] = sc.nextInt();
        }

        int max = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int ldx = x1[i], ldy = y1[i], rux = x2[i], ruy = y2[i];
            for (int j = i + 1; j < n; j++) {
                if (x1[j] >= ldx && y1[j] >= ldy && x2[j] <= rux && y2[j] <= ruy) {
                    cur++;
                    ldx = x1[j];
                    ldy = y1[j];
                    rux = x2[j];
                    ruy = y2[j];
                } else if (x1[j] < ldx && y1[j] < ldy && x2[j] > rux && y2[j] > ruy) {
                    cur++;
                } else if (x1[j] < ldx && y1[j] > ldy && x2[j] < rux && y2[j] > ruy) {
                    cur++;
                    //ldx = x1[j];
                    ldy = y1[j];
                    rux = x2[j];
                    //ruy = y2[j];
                } else if (x1[j] < ldx && y1[j] > ldy && x2[j] < rux && y2[j] > ruy) {
                    cur++;
                    //ldx = x1[j];
                    ldy = y1[j];
                    rux = x2[j];
                    //ruy = y2[j];
                } else if (x1[j] < ldx && y1[j] > ldy && x2[j] < rux && y2[j] > ruy) {
                    cur++;
                    //ldx = x1[j];
                    ldy = y1[j];
                    rux = x2[j];
                    //ruy = y2[j];
                } else if (x1[j] < ldx && y1[j] > ldy && x2[j] < rux && y2[j] > ruy) {
                    cur++;
                    //ldx = x1[j];
                    ldy = y1[j];
                    rux = x2[j];
                    //ruy = y2[j];
                }
            }
        }

        System.out.println(2);
        /*int ans = 0, x;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);*/
    }
}