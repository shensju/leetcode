import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/6/25 21:10
 * 0106 Construct Binary Tree from Inorder and Postorder Traversal（从中序和后序遍历序列构造二叉树）
 */
public class Solution0106 {

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

    private Map<Integer, Integer> indexMap;

    /**
     * 方法一：递归
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // 构造中序遍历的哈希映射，以便快速定位根结点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        if (inorder_left > inorder_right) {
            return null;
        }
        // 后序遍历中最后一个结点就是根结点
        int postorder_root = postorder_right;
        // 创建根结点
        TreeNode root = new TreeNode(postorder[postorder_root]);
        // 寻找根结点在中序遍历中的位置
        int inorder_root = indexMap.get(postorder[postorder_root]);
        // 计算中序遍历中根结点右子树中的结点数
        int size_right_subtree = inorder_right - inorder_root;
        // 递归构造根结点的右子树
        root.right = buildTree(inorder, postorder, inorder_root + 1, inorder_right, postorder_right - size_right_subtree, postorder_right - 1);
        // 递归构造根结点的左子树
        root.left = buildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left, postorder_right - size_right_subtree - 1);
        return root;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 96.97% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 38.9 MB, less than 64.19% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     */

    /**
     * 方法二：迭代
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        int n = postorder.length;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[n - 1]);
        stack.push(root);
        int inorderIndex = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            TreeNode node = stack.peek();
            int postorderValue = postorder[i];
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderValue);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderValue);
                stack.push(node.left);
            }
        }
        return root;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 3 ms, faster than 48.81% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 41.3 MB, less than 16.71% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     */
}
