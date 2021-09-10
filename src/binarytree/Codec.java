package binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/7/18 15:00
 * 二叉树的序列化与反序列化
 */
public class Codec {

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

    /** 方法一：广度优先搜索（Breadth First Search） **/

    /**
     * 将二叉树序列化为一个字符串
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        // 边界判断
        if (root == null)
            return "#";
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("#,");
                continue;
            }
            result.append(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return result.toString();
    }

    /**
     * 将字符串反序列化为一棵二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        // 边界判断
        if ("#".equals(data))
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode node = queue.poll();
            if (!"#".equals(values[i])) {
                TreeNode leftChild = new TreeNode(Integer.valueOf(values[i]));
                node.left = leftChild;
                queue.offer(leftChild);
            }
            if (!"#".equals(values[++i])) {
                TreeNode rightChild = new TreeNode(Integer.valueOf(values[i]));
                node.right = rightChild;
                queue.offer(rightChild);
            }
        }
        return root;
    }


    /** 方法二：深度优先搜索（Depth First Search） **/

    /**
     * 将二叉树序列化为一个字符串
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public String serialize2(TreeNode root) {
        // 边界判断
        if (root == null)
            return "#";
        return root.val + "," + serialize2(root.left) + "," + serialize2(root.right);
    }

    /**
     * 将字符串反序列化为一棵二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param data
     * @return
     */
    public TreeNode deserialize2(String data) {
        // 边界判断
        if ("#".equals(data))
            return null;
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return create(queue);
    }

    public TreeNode create(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = create(queue);
        root.right = create(queue);
        return root;
    }

}
