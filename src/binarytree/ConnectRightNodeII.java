package binarytree;

/**
 * @Author: shensju
 * @Date: 2021/7/18 11:04
 * 填充每个节点的下一个右侧节点指针 II
 */
public class ConnectRightNodeII {

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

    private Node nextStart = null;
    private Node nextLast = null;

    /**
     * 使用已建立的next指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node start = root;
        while (start != null) {
            nextStart = null;
            nextLast = null;
            Node last = start;
            for (; last != null; last = last.next) {
                if (last.left != null) {
                    handle(last.left);
                }
                if (last.right != null) {
                    handle(last.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node node) {
        if (nextStart == null) {
            nextStart = node;
        }
        if (nextLast != null) {
            nextLast.next = node;
            nextLast = node;
        }
        nextLast = node;
    }

}
