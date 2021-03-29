/**
 * @Author: shensju
 * @Date: 2021/3/29 22:21
 */
public class Solution0234 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0234 Palindrome Linked List **/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 寻找前半部分链表的尾结点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后半部分链表
        ListNode secondHalfStart = reverseList(slow.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean flag = true;
        while (flag && p2 != null) {
            if (p1.val != p2.val) {
                flag = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 恢复反转的后半部分链表
        reverseList(secondHalfStart);
        return flag;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 时间复杂度：(n)  空间复杂度：O(1)
     * Runtime: 5 ms, faster than 37.62% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 48.8 MB, less than 36.26% of Java online submissions for Palindrome Linked List.
     */
}
