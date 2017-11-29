package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Zhong on 2017/11/29.
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        int n = people.length;
        LinkedList<int[]> tmp = new LinkedList<>();
//        for (int i = 0; i < n; i++)
//            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        for (int[] p: people)
            tmp.add(p[1], new int[]{p[0], p[1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }
}
