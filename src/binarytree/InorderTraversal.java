package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/7/14 20:05
 * 二叉树的中序遍历：先遍历左子树，然后访问根节点，然后遍历右子树。
 */
public class InorderTraversal {

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
     * 迭代方式实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
        }
        return result;
    }

}
