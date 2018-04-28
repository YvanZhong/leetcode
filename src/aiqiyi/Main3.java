package aiqiyi;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        helper(20, 100, new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, new int[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10});
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] limit =new int[n];
        int ans = 1;
        int minNum = 0;
        for(int i = 0; i < n; i++){
            int tempMin = sc.nextInt();
            minNum +=tempMin;
            limit[i] = sc.nextInt() - tempMin;
        }
        if(minNum > m)
            ans = 0;
        else if(minNum == m)
            ans = 1;
        else{
            int less = m - minNum;
            int[][] dp= new int[less+1][n];
            for(int i = 0;i <= less;i++){
                for(int j = 0;j < n;j++){
                    if(i == 0)
                        dp[i][j] = 0;
                    else if(j == 0){
                        for(int x = i;x > 0 && x <= limit[j];x--) {
                            dp[i][j] = 1;
                            System.out.println("i j is "+x+" "+j+" "+dp[x][j]);
                        }
                    }
                    else{
                        for(int x = i;x > 0 && x <= limit[j];x--) {
                            System.out.println("i j is "+x+" "+j);
                            dp[i][j] += dp[x][j - 1];
                            //System.out.println("i j is"+i+" "+j+" "+dp[i][j]);
                        }
                    }
                }
            }
            for(int i = 0;i <= less;i++){
                for(int j = 0;j < n;j++)
                    System.out.print(dp[i][j]+ " ");
                System.out.println(" ");
            }
            ans = dp[less][n-1];
        }
        System.out.println(ans);
    }

    private static void helper(int n, int m, int[] l, int[] r) {
        long[] dp = new long[m + 1];
        long[] tmp = new long[m + 1];
        tmp[0] = 1;

        for (int i = 0; i < n; i++) {
            dp = new long[m + 1];
            for (int j = 0; j <= m && j + l[i] <= m; j++) {
                for (int z = l[i]; z <= r[i] && j + z <= m; z++) {
                    dp[j + z] += tmp[j];
                    if (j + z == 0) dp[0] = 1;
                    //System.out.println(j+z+ " " + dp[j+z]);
                }
            }
            for (int j = 0; j <= m; j++) {
                System.out.print(tmp[j] + " ");
            }
            System.out.println();
            long[] t = tmp;
            tmp = dp;
            dp = t;
        }

        System.out.println(tmp[m]);
    }

}
