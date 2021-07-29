package binarysearchtree;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: shensju
 * @Date: 2021/7/29 23:40
 * 0701 二叉搜索树中的插入操作
 */
public class InsertIntoBST {

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
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    /**
     * 迭代方式实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode parentNode = null;
        TreeNode currentNode = root;
        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.val < val) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        if (parentNode == null) {
            root = newNode;
        } else if (parentNode.val < val) {
            parentNode.right = newNode;
        } else {
            parentNode.left = newNode;
        }
        return root;
    }

}
