package nowcoder.wannafly;

import java.util.Scanner;

public class B_5 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int gold = (int)(number * 0.1);
        int ag = (int)(number * 0.2);
        int cu = (int)(number * 0.3);
        int f = number - gold - ag - cu;

        int real_gold = (int)Math.ceil(number * 0.1);
        int ag_gold = real_gold - gold;
        int real_ag = (int)Math.ceil(number * 0.2);
        int cu_ag = real_ag + ag_gold - ag;
        int real_cu = (int)Math.ceil(number * 0.3);
        int f_cu = real_cu + cu_ag - cu;
        int real_f = number - real_gold - real_ag - real_cu;

        System.out.println(ag_gold + " " + cu_ag + " " + f_cu);

    }
}
