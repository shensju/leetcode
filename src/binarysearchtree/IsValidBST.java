package binarysearchtree;

import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/7/20 23:30
 * 验证二叉搜索树
 */
public class IsValidBST {

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

    private long pre = Long.MIN_VALUE; // 中序遍历的前一个结点的值，初始值默认为 Long 的最小值

    /**
     * 递归方式实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    /**
     * 迭代方式实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

}
