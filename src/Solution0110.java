/**
 * @Author: shensju
 * @Date: 2021/6/29 22:28
 * 0110 Balanced Binary Tree（平衡二叉树）
 */
public class Solution0110 {

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

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }

    /**
     * 利用二叉树的后序遍历进行求解
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                flag = false;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Balanced Binary Tree.
     * Memory Usage: 39.1 MB, less than 59.79% of Java online submissions for Balanced Binary Tree.
     */
}
