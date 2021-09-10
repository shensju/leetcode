package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/7/14 20:16
 * 二叉树的后序遍历：先遍历左子树，然后遍历右子树，最后访问树的根节点。
 */
public class PostorderTraversal {

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
    public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root == null) {
            return result;
        }
        TreeNode temp = null;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
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
    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Boolean> stack2 = new Stack<>();
        TreeNode temp = root;
        Boolean flag;
        while (!stack1.isEmpty() || temp != null) {
            if (temp != null) {
                stack1.push(temp);
                stack2.push(false);
                temp = temp.left;
            } else {
                temp = stack1.pop();
                flag = stack2.pop();
                if (!flag) {
                    stack1.push(temp);
                    stack2.push(true);
                    temp = temp.right;
                } else {
                    result.add(temp.val);
                    temp = null;
                }
            }
        }
        return result;
    }

}
