package wangyi;

import java.util.Scanner;

public class Evelop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[26];
        for (int i = 0; i < 26; i++) {
            a[i] = sc.nextInt();
        }

        String str = sc.next();

        int row = 0, cur = 0;
        for (char c: str.toCharArray()) {
            cur += a[c - 'a'];
            if (cur > 100) {
                row++;
                cur = a[c - 'a'];
            }
        }

        row += 1;

        System.out.println(row + " " + cur);
    }
}
