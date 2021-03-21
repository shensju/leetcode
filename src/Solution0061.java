/**
 * @Author: shensju
 * @Date: 2021/3/20 23:07
 */
public class Solution0061 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0061 Rotate List **/
    public ListNode rotateRight(ListNode head, int k) {
        // 链表为空，或链表只有一个节点
        if (head == null) return null;
        if (head.next == null) return head;
        // 将链表闭合成环，同时计算出链表的长度n
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        // 新的链表尾，是第 n - k % n - 1 个节点
        // 新的链表头，是第 n - k % n 个节点
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail =  new_tail.next;
        }
        ListNode new_head = new_tail.next;
        // 断开环，返回新的链表头
        new_tail.next = null;
        return new_head;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
     * Memory Usage: 38.4 MB, less than 52.28% of Java online submissions for Rotate List.
     */
}
