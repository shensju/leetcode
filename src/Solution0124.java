/**
 * @Author: shensju
 * @Date: 2021/7/11 23:48
 * 0124 Binary Tree Maximum Path Sum（二叉树中的最大路径和）
 */
public class Solution0124 {

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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int newPathGain = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPathGain);
        return node.val + Math.max(leftGain, rightGain);
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 33.49% of Java online submissions for Binary Tree Maximum Path Sum.
     * Memory Usage: 45.2 MB, less than 7.02% of Java online submissions for Binary Tree Maximum Path Sum.
     */
}
