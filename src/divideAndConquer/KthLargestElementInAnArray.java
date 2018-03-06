package divideAndConquer;

import java.util.Random;

public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p > hi - k) hi = p - 1;
            else if (p < hi - k) lo = p + 1;
            else break;
        }

        return nums[k];
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while (i < hi && less(nums[++i], nums[lo]));
            while (less(nums[lo], nums[--j]));
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void shuffle(int a[]) {
        final Random random = new Random(); //why final
        for (int i = 1; i < a.length; i++) {
            int r = random.nextInt(i + 1);
            exch(a, i, r);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3};
        shuffle(a);
        System.out.println(findKthLargest(a, 1));
    }

}
