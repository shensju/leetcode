package binarysearchtree;

/**
 * @Author: shensju
 * @Date: 2021/8/8 22:00
 * 0110 平衡二叉树
 */
public class IsBalanced {

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
     * 递归方式实现，二叉树后序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
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
}
