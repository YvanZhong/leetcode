package stack;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();
        Stack<TreeNode> stack = new Stack();

        if (root == null) return res;

        stack.push(root);
        res.add(root.val);
        while (!stack.empty()) {
            TreeNode top = stack.peek();
            System.out.println(top.val);
            if (top.left != null) {
                stack.push(top.left);
                res.add(top.left.val);
                continue;
            }

            if (top.right != null) {
                stack.pop();
                stack.push(top.right);
                res.add(top.right.val);
                continue;
            }
            //stack.pop();
            while (!stack.empty() && stack.peek().right == null) stack.pop();
            if (!stack.empty()) {
                top = stack.pop();
                stack.push(top.right);
                res.add(top.right.val);
            }
        }

        return res;


    }

    public List<Integer> preorderTraversal2(TreeNode node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode t = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        t.right = t2;
//        TreeNode t3 = new TreeNode(3);
//        t2.left = t3;

        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t.left = t2;
        TreeNode t3 = new TreeNode(3);
        t.right = t3;

        System.out.println(preorderTraversal(t));
    }
}
