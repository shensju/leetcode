package binarytree;

/**
 * @Author: shensju
 * @Date: 2021/7/18 10:36
 * 填充每个节点的下一个右侧节点指针
 */
public class ConnectRightNodeI {

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
     * 使用已建立的next指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node head = root;
        while (head.left != null) {
            Node cur = head;
            while (cur.next != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next.left;
                cur = cur.next;
            }
            cur.left.next = cur.right;
            cur.right.next = null;
            head = head.left;
        }
        return root;
    }

}
