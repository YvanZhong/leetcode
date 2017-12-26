package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhong on 2017/12/26.
 */
public class MaximumLengthofPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int[] cur = pairs[0];
        int count = 1;

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > cur[0]) {
                cur = pairs[i];
                count++;
            }
        }

        return count;
    }
}
