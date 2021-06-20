import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/6/20 14:01
 * 0101 Symmetric Tree（对称二叉树）
 */
public class Solution0101 {

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
        return isMirror(root, root);
    }

    /**
     * 方式一：递归
     * @param p
     * @param q
     * @return
     */
    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
        return false;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 37.3 MB, less than 39.12% of Java online submissions for Symmetric Tree.
     */

    /**
     * 方法二：迭代
     * @param u
     * @param v
     * @return
     */
    private boolean isMirror2(TreeNode u, TreeNode v) {
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
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 26.51% of Java online submissions for Symmetric Tree.
     * Memory Usage: 38.4 MB, less than 20.11% of Java online submissions for Symmetric Tree.
     */
}
