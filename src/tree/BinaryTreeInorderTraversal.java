package tree;

import java.util.*;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        } else {
            List<Integer> ls = inorderTraversal(root.left);
            ls.add(root.val);
            ls.addAll(inorderTraversal(root.right));
            return ls;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {// Travel to each node's left child, till reach the left leaf
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop(); // Backtrack to higher level node A
            res.add(cur.val);  // Add the node to the result list
            cur = cur.right;   // Switch to A'right branch
        }
        return res;
    }
}
