package sort;

public class Quick3way { //三向切分快速排序

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];

        while (i <= gt) {
            int cmp = a[i].compareTo(v);

            if (cmp > 0) swap(a, i, gt--);
            else if (cmp < 0) swap(a, lt++, i++);
            else i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

    }

    private static void swap(Comparable[] a, int i ,int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{2,3,2,4,6,6,3};

        sort(a);
        for (int e : a) {
            System.out.println(e);
        }
    }

}
