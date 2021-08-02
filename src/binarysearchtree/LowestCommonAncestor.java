package binarysearchtree;

/**
 * @Author: shensju
 * @Date: 2021/8/2 21:25
 * 0235 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {

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
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 递归方式实现
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor2(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor2(root.right, p, q);
        return root;
    }

}
