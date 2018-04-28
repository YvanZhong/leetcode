package baidu;

import java.util.Scanner;

//736128000
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int i = 1;
        int count = 2;
        long res = 120;
        while (i < n) {
            System.out.println(count + 1);
            /*res *= (count + 1);
            res %= 1000000007;
            res *= (count + 1);
            res %= 1000000007;
            res *= 120;
            res %= 1000000007;*/
            long tmp = (count + 1) * (count + 1);
            tmp %= 1000000007;
            tmp *= 120;
            tmp %= 1000000007;
            res *= tmp;
            res %= 1000000007;
            count += 2;
            i++;
        }
        System.out.println(res);
        /*long pow = pow(120, n);
        long factorial = factorial(n);
        System.out.println((pow % 1000000007 ) * (factorial % 1000000007));*/
    }

    private static long pow(int n, int e) {
        long p = n;
        long rst = 1;
        while (e > 0) {
            if ((e & 1) == 1) {
                rst *= p;
                rst %= 1000000007;
            }
            p = p * p;
            p %= 1000000007;
            e >>= 1;
        }
        return rst;
    }

    private static long factorial(long n) {
        long rst = 1;
        while (n > 0) {
            rst *= n;
            rst %= 1000000007;
            n--;
        }
        return rst;
    }

}
