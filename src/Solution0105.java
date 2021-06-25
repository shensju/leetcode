import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: shensju
 * @Date: 2021/6/24 22:26
 * 0105 Construct Binary Tree from Preorder and Inorder Traversal（从前序与中序遍历构造二叉树）
 */
public class Solution0105 {

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
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造中序遍历的哈希映射，以便快速定位根结点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中第一个结点就是根结点
        int preorder_root = preorder_left;
        // 寻找根结点在中序遍历中的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 创建根结点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 计算中序遍历中根结点的左子树中的结点数
        int size_left_subtree = inorder_root - inorder_left;
        // 递归构造根结点的左子树
        root.left = buildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归构造根结点的右子树
        root.right = buildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 99.05% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 39.2 MB, less than 52.00% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */

    /**
     * 方法二：迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderValue = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderValue);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderValue);
                stack.push(node.right);
            }
        }
        return root;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 99.05% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     * Memory Usage: 38.7 MB, less than 92.89% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     */
}
