package wangyi;

//import scala.Int;

import java.util.HashMap;
import java.util.Scanner;

public class Bag {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weight = sc.nextInt();
        int[] food = new int[n];
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            food[i] = sc.nextInt();
            sum += food[i];
            if (sum < 0) flag = false;
        }

        if (flag && sum < weight) System.out.println((int)Math.pow(2, n));
        else System.out.println(calculate(food, weight, 0));
    }

    public static int calculate(int[] food, int weight, int start) {
        if (start >= food.length) return 1;
        //System.out.println(weight + " " + start);
        if (food[start] > weight) {
            return calculate(food, weight, start + 1);
        } else if (food[start] != weight){
            return calculate(food, weight, start + 1) + calculate(food, weight - food[start], start + 1);
        } else {
            return 2 * calculate(food, weight, start + 1);
        }
    }

    public static int calculate1(int[] food, int weight, int start) {
        if (start >= food.length) return 1;
        //System.out.println(weight + " " + start);
        if (food[start] > weight) {
            return calculate(food, weight, start + 1);
        } else {
            return calculate(food, weight, start + 1) + calculate(food, weight - food[start], start + 1);
        }
    }

}
