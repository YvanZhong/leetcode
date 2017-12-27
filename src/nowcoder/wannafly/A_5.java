package nowcoder.wannafly;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_5 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        int rst = 0;

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
            if (isSqure(arr[i])) {
                rst++;
            }

//            if (arr[i] != 0 ) {
            for (int j = 0; j < i; j++) {
                arr[j] += arr[i];
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j], isSqure(arr[j]));
                }
                if (map.get(arr[j])) {
                    rst++;
                }
            }
//            }
        }

//        System.out.println(count);
        /*for (int i = 0; i < count; i++) {
            int val = 0;
            for (int j = i; j < count; j++) {
                val += arr[j];
                if (isSqure(val)) {
                    rst++;
                }
            }
        }*/

        System.out.println(rst);
    }

    private static boolean isSqure(int number) {
        int sqrt = (int) Math.sqrt(number);
//        System.out.println(sqrt);
        return sqrt * sqrt == number;
    }
}
