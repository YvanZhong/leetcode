package backtracking;

/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.
 */
//@cdai
public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        return doCount(Math.min(n, 10), new boolean[10], 0);
    }

    private int doCount(int n, boolean[] used, int d) {
        if (d == n) return 1;
        int total = 1;
        for (int i = (d == 0) ? 1 : 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                total += doCount(n, used, d + 1);
                used[i] = false;
            }
        }
        return total;
    }

    static public void main(String[] args) {
        System.out.println(new CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(10));
    }
}
