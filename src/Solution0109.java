import java.util.List;

/**
 * @Author: shensju
 * @Date: 2021/6/28 21:25
 * 0109 Convert Sorted List to Binary Search Tree（有序链表转换二叉搜索树）
 */
public class Solution0109 {

    /** Definition for singly-linked list. **/
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
     * 方法一：分治
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode midNode = getMidNode(left, right);
        TreeNode root = new TreeNode(midNode.val);
        root.left = buildTree(left, midNode);
        root.right = buildTree(midNode.next, right);
        return root;
    }

    /**
     * 快慢指针法
     * @param left
     * @param right
     * @return
     */
    private ListNode getMidNode(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 时间复杂度：O(nlogn)  空间复杂度：O(logn)
     * Runtime: 1 ms, faster than 36.23% of Java online submissions for Convert Sorted List to Binary Search Tree.
     * Memory Usage: 40.1 MB, less than 28.50% of Java online submissions for Convert Sorted List to Binary Search Tree.
     */

    /**
     * 方法二：分治 + 中序遍历
     */

    private ListNode node;

    public TreeNode sortedListToBST2(ListNode head) {
        node = head;
        // 计算链表的结点数
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return buildTree(0, count - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = node.val;
        node = node.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    /**
     * 时间复杂度的：O(n)  空间复杂度：O(logn)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted List to Binary Search Tree.
     * Memory Usage: 40.1 MB, less than 28.50% of Java online submissions for Convert Sorted List to Binary Search Tree.
     */
}
