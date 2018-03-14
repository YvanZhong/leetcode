package codility;

public class MinMaxDivision {

    public static int solution(int K, int M, int[] A) {
        int lower = max(A);  // why lower is max?
        int upper = sum(A);  // why upper is sum?
        if (K >= A.length) return lower;
        if (K == 1) return upper;
        while (true) {
            int mid = (lower + upper) / 2;
            int blocks = calculateBlockCount(A, mid); // don't I have specified number of blocks? What blocks do? Don't get that.
            if (blocks < K) {
                upper = mid - 1;
            } else if (blocks > K) {
                lower = mid + 1;
            } else {
                return upper;
            }
        }
    }

    private static int calculateBlockCount(int[] array, int maxSum) {
        int count = 0;
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum + array[i] > maxSum) {
                count++;
                sum = array[i];
            } else {
                sum += array[i];
            }
        }
        return count;
    }

    // returns sum of all elements in an array
    private static int sum(int[] input) {
        int sum = 0;
        for (int n : input) {
            sum += n;
        }
        return sum;
    }

    // returns max value in an array
    private static int max(int[] input) {
        int max = -1;
        for (int n : input) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public static void main(String... args) {
        int b = solution(10, 5, new int[]{2,1,5,1,2,2,2});

        int a = 1;
    }
}
