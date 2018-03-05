package sort;

public class Merge {

    private static int[] helper;

    private static Comparable[] aux; //aux 辅助的

    public static void sort(int []a) {
        helper = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int []a, int lo, int hi) {
        if (lo >= hi) return;
        /*if (lo == hi - 1) {  //属于merge
            if (a[lo] > a[hi]) {
                int tmp = a[hi];
                a[hi] = a[lo];
                a[lo] = tmp;
            }
            return;
        }*/

        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int []a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int z = lo;
        for (; i <= mid && j <= hi;) {
            if (a[i] < a[j]) {
                helper[z++] = a[i];
                i++;
            } else {
                helper[z++] = a[j];
                j++;
            }
        }

        for(;i <= mid; i++) {
            helper[z++] = a[i];
        }

        for (; j <= hi;j++) {
            helper[z++] = a[j];
        }

        for (z = lo; z <= hi; z++) {
            a[z] = helper[z];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,4,6,8,3};

        sort(a);
        for (int e : a) {
            System.out.println(e);
        }

        System.out.println("========");

        Integer[] b = new Integer[]{2,3,1,4,6,8,3};
        sort(b);
        for (int e : b) {
            System.out.println(e);
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int l, int h) {
        if (l >= h) return;

        int mid = l + (h - l) / 2;
        sort(a, l, mid);
        sort(a, mid + 1, h);
        merge(a, l, mid, h);
    }

    private static void merge(Comparable[] a, int l, int mid, int h) {
        int i = l;
        int j = mid + 1;
        for (int z = l; z <= h; z++) {
            aux[z] = a[z];
        }

        for (int z = l; z <= h; z++) {
            if (i > mid) a[z] = aux[j++];
            else if (j > h) a[z] = aux[i++];
            else if (a[i].compareTo(a[j]) > 0) a[z] = aux[j++];
            else a[z] = aux[i++];
        }
    }
}
