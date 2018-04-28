package chenxi;

public class Solution {

    public static void main(String[] args) {
        int x = 3;
        int y = 100;
        int z = 20;
        int a = 100;

        helper(z, a, x, y);

        /*int[] nums = new int[x];
        for (int i = 0; i < x; i++) {
            nums[i] = 201;
        }

        for (int i = 0; i < x; i++) {
            for (int offset = 0; offset < a - 200; offset++) {
                nums[i] += offset;
                int sum = 0;
                for (int j = 0; j < x; j++) {
                    sum += nums[j];
                }
                if (sum == y) {
                    for (int j = 0; j < x; j++) {
                        System.out.print(nums[j] + " ");
                    }
                }
            }
        }*/
    }

    private static int helper(int z, int a, int x, int y) {
        if (x == 1) {
            if (y > z && y < a) {
                System.out.println(y+" end");
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        for (int i = z + 1; i < Math.min(a, y) - (x-1) * z; i++) {
            if (y - i < 0) break;
            System.out.print(i + " ");
            count += helper(z, a, x - 1, y - i);
        }
        return count;
    }

}
