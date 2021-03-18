/**
 * @Author: shensju
 * @Date: 2021/3/17 23:24
 */
public class Solution0206 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0206 Reverse Linked List **/

    /** 方法一：迭代 **/
    public ListNode reverseList01(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 38.8 MB, less than 53.54% of Java online submissions for Reverse Linked List.
     */

    /** 方法二：递归 **/
    public ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList02(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 39.2 MB, less than 25.55% of Java online submissions for Reverse Linked List.
     */
}
