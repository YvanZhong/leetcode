package meituan;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            System.out.println(getCount(scanner.nextInt()));
            t--;
        }
    }

    public static long getCount(int x) {
        long flag = 1;
        long count = 1;
        long res = 0;
        while (x >= flag * 10) {
            res += (flag * 10 - flag) * count;
            count++;
            flag *= 10;
        }
        res += (x - flag + 1) * count;
        return res;
    }

}
