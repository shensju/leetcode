import java.util.Random;

/**
 * @Author: shensju
 * @Date: 2021/6/28 21:11
 * 0108 Convert Sorted Array to Binary Search Tree（将有序数组转换为二叉搜索树）
 */
public class Solution0108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(logn)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 38.8 MB, less than 50.33% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     */
}
