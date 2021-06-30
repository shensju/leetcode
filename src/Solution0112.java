import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/6/30 22:19
 * 0112 Path Sum（路径总和）
 */
public class Solution0112 {

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

    public class QueueNode {
        private TreeNode treeNode;
        private int sum;
        public QueueNode(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }

    /**
     * 方法一：迭代，广度优先搜索
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, root.val));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int sum = queueNode.sum;
            if (treeNode.left == null && treeNode.right == null && sum == targetSum) {
                return true;
            }
            if (treeNode.left != null) {
                queue.offer(new QueueNode(treeNode.left, sum + treeNode.left.val));
            }
            if (treeNode.right != null) {
                queue.offer(new QueueNode(treeNode.right, sum + treeNode.right.val));
            }
        }
        return false;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 18.97% of Java online submissions for Path Sum.
     * Memory Usage: 38.9 MB, less than 48.95% of Java online submissions for Path Sum.
     */

    /**
     * 方法二：递归，深度优先搜索
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 39.1 MB, less than 27.03% of Java online submissions for Path Sum.
     */
}
