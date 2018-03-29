package wangyi;

import java.util.Scanner;

public class Loss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char state = 'N';

        for (int i = 0; i < n; i++) {
            switch (state) {
                case 'N':
                    if (str.charAt(i) == 'L') state = 'W';
                    else state = 'E';
                    break;
                case 'E':
                    if (str.charAt(i) == 'L') state = 'N';
                    else state = 'S';
                    break;
                case 'S':
                    if (str.charAt(i) == 'L') state = 'E';
                    else state = 'W';
                    break;
                case 'W':
                    if (str.charAt(i) == 'L') state = 'S';
                    else state = 'N';
                    break;
            }

        }

        System.out.println(state);



    }
}
