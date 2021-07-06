import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shensju
 * @Date: 2021/7/5 23:36
 * 0116 Populating Next Right Pointers in Each Node（填充每个节点的下一个右侧节点指针）
 */
public class Solution0116 {

    /** Definition for a Node **/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (prev == null) {
                    prev = cur;
                } else {
                    prev.next = cur;
                    prev = cur;
                }
            }
            prev.next = null;
        }
        return root;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 1 ms, faster than 55.44% of Java online submissions for Populating Next Right Pointers in Each Node.
     * Memory Usage: 38.6 MB, less than 99.85% of Java online submissions for Populating Next Right Pointers in Each Node.
     */

    /**
     * 使用已建立的next指针
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node leftNode = root;
        while (leftNode.left != null) {
            Node head = leftNode;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
     * Memory Usage: 39.1 MB, less than 72.93% of Java online submissions for Populating Next Right Pointers in Each Node.
     */
}
