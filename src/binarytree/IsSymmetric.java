package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/7/16 20:02
 * 对称二叉树
 */
public class IsSymmetric {

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

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRecursive(root, root);
    }

    /**
     * 递归方式实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param p
     * @param q
     * @return
     */
    private boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSymmetricRecursive(p.left, q.right) && isSymmetricRecursive(p.right, q.left);
        }
        return false;
    }

    /**
     * 迭代方式实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param u
     * @param v
     * @return
     */
    private boolean isSymmetricIterative(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null) {
                return false;
            }
            if (u.val != v.val) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }

}
