import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/6/16 19:53
 * 0098 Validate Binary Search Tree（验证二叉搜索树）
 */
public class Solution0098 {

    long pre = Long.MIN_VALUE; // 中序遍历的前一个结点的值，初始值默认为 Long 的最小值

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
     * 中序遍历，递归版本
     * @param root 根结点
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
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.5 MB, less than 71.13% of Java online submissions for Validate Binary Search Tree.
     */

    /**
     * 中序遍历，非递归版本
     * @param root 根结点
     * @return
     */
    public boolean isValidBSTNR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
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
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 32.62% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.5 MB, less than 59.50% of Java online submissions for Validate Binary Search Tree.
     */
}
