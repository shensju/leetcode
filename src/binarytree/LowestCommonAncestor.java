package binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: shensju
 * @Date: 2021/7/18 11:22
 * 二叉树的最近公共祖先
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

    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    /**
     * 存储父结点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        setParent(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void setParent(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            setParent(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            setParent(root.right);
        }
    }

    private TreeNode resultNode;

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return this.resultNode;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.resultNode = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
