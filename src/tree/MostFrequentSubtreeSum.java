package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhong on 2017/12/1.
 */

public class MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);

        int max = 0;
        int count = 0;
        List<Integer> ls = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                count = 1;
                ls.clear();
                ls.add(entry.getKey());
            } else if (entry.getValue() == max) {
                count++;
                ls.add(entry.getKey());
            }
        }

        int[] result = new int[ls.size()];
        int i = 0;
        for (int e: ls) {
            result[i] = e;
            i++;
        }
        return result;
    }

    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return root.val;
        } else {
            int val = root.val;
            if (root.left != null) {
                val += helper(root.left, map);
            }

            if (root.right != null) {
                val += helper(root.right, map);
            }

            map.put(val, map.getOrDefault(val, 0) + 1);
            return val;
        }
    }
}
