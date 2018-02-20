package bitManipulation;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int radius = Integer.MIN_VALUE;
        for (int h: houses) {
            int index = Arrays.binarySearch(heaters, h);
            if (index < 0) {
                index = -(index + 1);
                int l = index - 1;
                int r = index;
                radius = Math.max(radius, Math.min(l >= 0 ? h - heaters[l] : Integer.MAX_VALUE, r < heaters.length ? heaters[r] - h : Integer.MAX_VALUE));
            } else {
                radius = Math.max(0, radius);
            }
        }

        return radius;
    }

    public int reverseBits(int n) {
        Integer.reverse(n);

        int rst = 0;
        for (int i = 0; i < 32; i++) {
            rst <<= 1;
            rst |= n&1;
            n >>= 1;
        }
        return rst;
    }
}
