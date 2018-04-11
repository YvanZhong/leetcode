package wangyi;

import java.util.*;

public class Candy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        String[] s = string.split(" ");

        Map<Integer, Integer> map = new HashMap();

        for (String str: s) {
            int val = Integer.valueOf(str);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int res = 0;
        for (int i: map.keySet()) {
            int tmp = 0;
            if ((map.get(i) % (i + 1)) == 0) {
                tmp = map.get(i) / (i + 1);
            } else {
                tmp = map.get(i) / (i + 1) + 1;
            }
            res += tmp * (i + 1);
        }

        System.out.println(res);


    }

    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;

        int ans = 0;
        for (int k = 0; k < 1000; ++k) {
            ans += Math.floorMod(-count[k], k+1) + count[k];
            //int group = count[k] / (k + 1);
            //ans += (count[k] % (k + 1) == 0)? group * (k+1) : (group+1) * (k+ 1);
        }
        return ans;
    }
}
