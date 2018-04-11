package wangyi;

import java.util.Scanner;

public class Shoot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int shootR = sc.nextInt();
        int shoorC = sc.nextInt();

        int[][] a = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        a[shootR][shoorC] = 0;

        for (int i = 0; i < col; i++) {
            if (a[0][i] == 1)
                reset(a, 0, i);
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1) res++;
            }
        }

        System.out.println(res);

    }

    private static void reset(int[][] a, int x, int y) {
        if (a[x][y] == -1 || a[x][y] == 0) {
            return;
        } else {
            a[x][y] = -1;
            if (x > 1) reset(a, x - 1, y);
            if (x < a.length - 1) reset(a, x + 1, y);
            if (y > 0) reset(a, x, y - 1);
            if (y < a[0].length - 1) reset(a, x, y + 1);
        }
    }

}
