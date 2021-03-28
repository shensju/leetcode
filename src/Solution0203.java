/**
 * @Author: shensju
 * @Date: 2021/3/28 23:22
 */
public class Solution0203 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0203 Remove Linked List Elements **/
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummyNode.next;
    }

    /**
     * 时间复杂度：(n)  空间复杂度：O(1)
     * Runtime: 1 ms, faster than 78.89% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 39.7 MB, less than 70.96% of Java online submissions for Remove Linked List Elements.
     */
}
