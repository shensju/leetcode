import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/7/1 23:36
 * 0113 Path Sum II（路径总和 II）
 */
public class Solution0113 {

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

    private List<List<Integer>> result = new LinkedList<>();

    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path(root, targetSum);
        return result;
    }

    /**
     * 深度优先搜索
     * @param root
     * @param targetSum
     */
    private void path(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new LinkedList<>(path));
        }
        path(root.left, targetSum);
        path(root.right, targetSum);
        path.pollLast();
    }

    /**
     * 时间复杂度：O(n^2)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 99.93% of Java online submissions for Path Sum II.
     * Memory Usage: 39.4 MB, less than 64.47% of Java online submissions for Path Sum II.
     */
}
