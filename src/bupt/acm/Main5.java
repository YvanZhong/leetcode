package bupt.acm;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
            }
            count += i;
        }
        double start = System.currentTimeMillis();
        System.out.println(count);
        //System.out.println((System.currentTimeMillis()-start)/1000);
    }

    static long euler(int n) { //返回euler(n)
        long res = n, a = n;
        for (long i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                res = res / i * (i - 1);//先进行除法是为了防止中间数据的溢出
                while (a % i == 0) a /= i;
            }
        }
        if (a > 1) res = res / a * (a - 1);
        return res;
    }




    public static long see(int n) {
        long res = 0;
        // 欧拉公式解
        for (int i = 1; i <= n; ++i){
            System.out.println(euler(i));
            res += euler(i);
        }
//        // 暴力解
//        for (int i = 1; i <= n; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (Math.abs(gcd(i-x, j-y)) == 1) res++;
//            }
//        }
        return res+1;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        if (a < b) return gcd(b, a%b);
        else return gcd(b, a%b);
    }
}

