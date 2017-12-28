package nowcoder;

import java.io.InputStream;
import java.util.Scanner;

public class A_38 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int round = scanner.nextInt();
        int[] alice = new int[6];
        StringBuilder sb = new StringBuilder();
        while (round > 0) {
            int i = 0, j = 0;
            int a = 0;
            int count = 0;
            int al = 0, bo = 0;
            while (i < 6) {
                alice[i] = scanner.nextInt();
                a += alice[i];
                i++;
            }
            while (j < 6) {
                int tmp = scanner.nextInt();
                i = 0;
                while (i < 6) {
                    if (alice[i] > tmp) al++;
                    if (alice[i] < tmp) bo++;
                    i++;
                }
                j++;
            }//System.out.println(count);
            if (al > bo) sb.append("Alice\n");//System.out.println("Alice");
            else if (al < bo) sb.append("Bob\n");//System.out.println("Bob");
            else sb.append("Tie\n");//System.out.println("Tie");
            round--;
        }
        System.out.println(sb.toString());
    }

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;

        int start = 0, end = array.length - 1;

        while (start < end) {
            if (array[start] < array[end]) {
                return array[start];
            } else {
                int mid = start + (end - start) / 2;
                if (array[mid] >= array[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        return array[start];
    }

    public static void main(String[] args) {
        System.out.println(new A_38().minNumberInRotateArray(new int[]{2,1,2,2,2}));
    }
}
