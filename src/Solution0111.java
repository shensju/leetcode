import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/6/29 23:20
 * 0111 Minimum Depth of Binary Tree（二叉树的最小深度）
 */
public class Solution0111 {

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

    /**
     * 方法一：递归，深度优先搜索
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 5 ms, faster than 64.55% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 59.2 MB, less than 81.08% of Java online submissions for Minimum Depth of Binary Tree.
     */

    /**
     * 方法二：迭代，广度优先搜索
     */
    public class QueueNode {

        private TreeNode treeNode;
        private int depth;

        public QueueNode(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int depth = queueNode.depth;
            // 当前结点是叶子结点时，直接返回当前结点的深度，此时为整棵二叉树的最小深度
            if (treeNode.left == null && treeNode.right == null) {
                return depth;
            }
            if (treeNode.left != null) {
                queue.offer(new QueueNode(treeNode.left, depth + 1));
            }
            if (treeNode.right != null) {
                queue.offer(new QueueNode(treeNode.right, depth + 1));
            }
        }
        return 0;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 85.08% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 59 MB, less than 86.46% of Java online submissions for Minimum Depth of Binary Tree.
     */
}
