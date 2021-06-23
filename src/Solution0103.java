import java.util.*;

/**
 * @Author: shensju
 * @Date: 2021/6/23 20:11
 * 0103 Binary Tree Zigzag Level Order Traversal（二叉树的锯齿形层序遍历）
 */
public class Solution0103 {

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
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> tempQueue = new LinkedList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = queue.poll();
                if (isOrderLeft) {
                    tempQueue.offerLast(currentNode.val);
                } else {
                    tempQueue.offerFirst(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(new LinkedList<Integer>(tempQueue));
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 74.64% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 39.1 MB, less than 54.93% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     */
}
