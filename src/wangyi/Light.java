package wangyi;

import java.util.Scanner;

public class Light {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            //System.out.println(l);
            //char[] street = new char[l];
            String street = sc.next();
            calculate(street);
        }


    }

    private static void calculate(String street) {
        int count = 0;
        for (int i = 0; i < street.length(); ) {
            if (street.charAt(i) == '.') {
                if (i + 2 < street.length() && street.charAt(i + 2) == '.') {
                    count++;
                    i = i + 3;
                } else if (i + 1 < street.length() && street.charAt(i + 1) == '.') {
                    count++;
                    i = i + 3;
                } else {
                    count++;
                    i = i + 3;
                }
            } else {
                i++;
            }
        }
        System.out.println(count);
    }

}
