package wangyi;

import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        /*int left = 0;
        int last = 0;
        int count = 0;
        for (int i = 1; i <= r; i++) {
            last = last + 1;
            last %= 3;
            left = (left + last) % 3;
            if (i >= l && left == 0) {
                count++;
            }
        }

        System.out.println(count);*/

        System.out.println(r - (r+2)/3 - (l+1)/3 + l - 1);

    }

}
