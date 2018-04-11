package stack;

import java.util.Stack;

public class Trip {

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack();

        int count = 0, level = 0, stackMax = 0, cur = 0;
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || stack.peek() >= height[i]) {
                stack.push(height[i]);
                stackMax = Math.max(stackMax, height[i]);
            } else {
                int curMax = Math.min(stackMax, height[i]);
                cur += (curMax - level) * count;
                level = curMax;

                while (!stack.empty() && stack.peek() < height[i]) {
                    count++;
                    cur += curMax - stack.pop();
                }
                if (stack.empty()) {
                    total += cur;
                    cur = 0;
                    count = 0;
                    level = 0;
                    stackMax = 0;
                }
                stack.push(height[i]);
                stackMax = Math.max(stackMax, height[i]);
            }
        }
        total += cur;

        return total;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {3,2,1,2,1}));
    }

}
