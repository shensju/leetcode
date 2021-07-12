import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/7/12 22:11
 * 0129 Sum Root to Leaf Numbers（ 求根节点到叶节点数字之和）
 */
public class Solution0129 {

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
     * 方法一：深度优先遍历
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return pathNumber(root, 0);
    }

    private int pathNumber(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return pathNumber(node.left, sum) + pathNumber(node.right, sum);
        }
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 38.4 MB, less than 10.13% of Java online submissions for Sum Root to Leaf Numbers.
     */

    /**
     * 方法二：广度优先搜素
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numberQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numberQueue.offer(root.val);
        int sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int number = numberQueue.poll();
            if (node.left == null && node.right == null) {
                sum += number;
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    numberQueue.offer(number * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    numberQueue.offer(number * 10 + node.right.val);
                }
            }
        }
        return sum;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 26.43% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 38.8 MB, less than 5.41% of Java online submissions for Sum Root to Leaf Numbers.
     */
}
