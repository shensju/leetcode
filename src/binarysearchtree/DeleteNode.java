package binarysearchtree;

/**
 * @Author: shensju
 * @Date: 2021/7/31 23:40
 * 0450 删除二叉搜索树中的节点
 */
public class DeleteNode {

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
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.right != null) {
                root.val = successor(root);
                // 递归向下操作以删除后继结点
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                // 递归向下操作以删除前驱结点
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * 返回中序遍历中当前结点的前一个结点，即比当前结点值小的最大结点
     * @param root
     * @return
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root != null && root.right != null)
            root = root.right;
        return root.val;
    }

    /**
     * 返回中序遍历中当前结点的后一个结点，即比当前结点值大的最小结点
     * @param root
     * @return
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root != null && root.left != null)
            root = root.left;
        return root.val;
    }
}
