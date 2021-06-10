import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/6/10 22:23
 */
public class Solution0094 {

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
     * 二叉树的中序遍历
     * 0094 Binary Tree Inorder Traversal
     * @param root 根结点
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

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.1 MB, less than 67.06% of Java online submissions for Binary Tree Inorder Traversal.
     */
}