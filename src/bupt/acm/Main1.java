package bupt.acm;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while (count > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            query(a);
            count--;
        }
    }

    private static void query(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0 && a[i] < a.length && a[a[i]] != a[i]) {
                int tmp = a[i];
                a[i] = a[a[i]];
                //System.out.println(a[i]);
                a[tmp] = tmp;
                i--;
            }
        }

        int i = 0;
        for (; i < a.length && a[i] == i; i++) {

        }

        System.out.println(i);
    }

}
