package binarysearchtree;

/**
 * @Author: shensju
 * @Date: 2021/7/27 23:17
 * 0700 二叉搜索树中的搜索
 */
public class SearchBST {

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
     * 递归方式实现
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBSTRecursive(root.left, val);
        } else if (root.val < val) {
            return searchBSTRecursive(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 递归方式实现
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (root.val > val) {
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }
}
