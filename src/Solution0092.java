/**
 * @Author: shensju
 * @Date: 2021/3/18 23:21
 */
public class Solution0092 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0092 Reverse Linked List II **/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode leftNode = prev.next;
        ListNode succ = prev;
        for (int i = left - 1; i < right; i++) {
            succ = succ.next;
        }
        ListNode rightNode = succ;
        succ = succ.next;

        prev.next = null;
        rightNode.next = null;

        reverseList(leftNode);
        prev.next = rightNode;
        leftNode.next = succ;

        return dummyNode.next;
    }

    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 36.8 MB, less than 28.17% of Java online submissions for Reverse Linked List II.
     */
}
