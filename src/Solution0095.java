import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/6/15 22:18
 * 0095 Unique Binary Search Trees II（不同的二叉搜索树 II）
 */
public class Solution0095 {

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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * 回溯法
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = left;
                    tree.right = right;
                    allTrees.add(tree);
                }
            }
        }
        return allTrees;
    }

    /**
     * Runtime: 1 ms, faster than 93.55% of Java online submissions for Unique Binary Search Trees II.
     * Memory Usage: 40.2 MB, less than 20.15% of Java online submissions for Unique Binary Search Trees II.
     */
}
