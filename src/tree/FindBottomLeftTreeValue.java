package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zhong on 2017/11/29.
 */
public class FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.add(root);
        return helper(q1, new LinkedList<>(), root.val);
    }

    private int helper(Queue<TreeNode> q1, Queue<TreeNode> q2, int left) {
        if (q1.isEmpty()) return left;

        left = q1.peek().val;
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);
        }

        return helper(q2, q1, left);
    }
}
