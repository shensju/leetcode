package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/7/13 23:46
 * 二叉树的前序遍历：首先访问根节点，然后遍历左子树，最后遍历右子树。
 */
public class PreorderTraversal {

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
     * 迭代方式实现一
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return result;
    }

    /**
     * 迭代方式实现二
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                result.add(temp.val);
                temp = temp.left;
            } else {
                temp = stack.pop();
                temp = temp.right;
            }
        }
        return result;
    }

}
