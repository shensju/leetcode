import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/7/3 22:40
 * 0114 Flatten Binary Tree to Linked List（二叉树展开为链表）
 */
public class Solution0114 {

    /** Definition for a binary tree node **/
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prevNode = null;
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (prevNode != null) {
                prevNode.right = currentNode;
                prevNode.left = null;
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            prevNode = currentNode;
        }
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 2 ms, faster than 27.86% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 39.6 MB, less than 5.65% of Java online submissions for Flatten Binary Tree to Linked List.
     */

    public void flatten2(TreeNode root) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode nextNode = currentNode.left;
                TreeNode prevNode = nextNode;
                while (prevNode.right != null) {
                    prevNode = prevNode.right;
                }
                prevNode.right = currentNode.right;
                currentNode.left = null;
                currentNode.right = nextNode;
            }
            currentNode = currentNode.right;
        }
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 37.7 MB, less than 80.77% of Java online submissions for Flatten Binary Tree to Linked List.
     */
}
