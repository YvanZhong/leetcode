package wangyi;

import java.util.Scanner;

public class Main2 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int sum = 0;
        int times = 1;
        for (int i = k; i < n; i++) {
            sum += n - i;
        }

        /*for (int i = k + 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == k) sum++;
            }
        }*/
        for (int j = k + 1; j <=n-k; j++) {
            times = 1;
            while (j * times + k <= n) {
                System.out.println(j-k);
                times++;
                sum += j - k;
            }
        }


        System.out.println(sum);


    }

    public static void main(String[] args) {
        long res = 0;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (y == 0) {
            res = x * x;
        } else {
            for (int i = 1; i <= x; i++){
                if (i > y){
                    if ((x % i - y + 1) > 0)res += ((i-y) * (x/i) + (x%i-y+1));
                    else res += ((i - y) * (int)(x / i));
                }
            }
        }
        System.out.println(res);
    }
}
