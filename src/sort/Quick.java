package sort;

public class Quick {

    public static void sort(int[] a) {
        sort(a, 0 , a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition1(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partition1(int[] a, int lo, int hi) {
        int h = a[lo];
        int i = lo + 1;
        int j = hi;

        while(true) {
            while(a[i] <= h && i < j) i++;
            while(a[j] >= h && j >= i) j--;
            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
            else {
                swap(a, lo, j);
                break;
            }
        }
        return j;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (v < a[--j]) /*if (j == lo) break*/;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partition3(int[] a, int lo, int hi) {
        int pivot = a[(lo + hi) / 2];
        while(lo <= hi) {
            while(a[lo] < pivot) lo++;

            while(a[hi] > pivot) hi--;

            if (lo <= hi) {
                int tmp = a[lo];
                a[lo] = a[hi];
                a[hi] = tmp;
                lo++;
                hi--;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,4,6,8,3};

        sort(a);
        for (int e : a) {
            System.out.println(e);
        }
    }

}
