/**
 * @Author: shensju
 * @Date: 2021/3/16 23:15
 */
public class Solution0019 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0019 Remove Nth Node From End of List **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode r = head;
        while (r != null) {
            count++;
            r = r.next;
        }
        ListNode p = head;
        ListNode q;
        int index = 0;
        if (index + count == n) {
            return p.next;
        }
        q = p;
        p = p.next;
        index++;
        while (count + (-index) != n) {
            q = p;
            p = p.next;
            index++;
        }
        q.next = p.next;
        return head;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37 MB, less than 49.78% of Java online submissions for Remove Nth Node From End of List.
     */
}
