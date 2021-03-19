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
    public ListNode reverseBetween01(ListNode head, int left, int right) {
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

    public ListNode reverseBetween02(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }

    /**
     * 时间复杂度：O(n)，其中 n 是链表的总结点数，最多只遍历了链表一次，就完成了反转。
     * 空间复杂度：O(1)，只使用到常数个变量。
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 36.5 MB, less than 66.67% of Java online submissions for Reverse Linked List II.
     */
}
