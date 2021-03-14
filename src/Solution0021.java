/**
 * @Author: shensju
 * @Date: 2021/3/14 23:32
 */
public class Solution0021 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0021 Merge Two Sorted Lists **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 时间复杂度：O(m + n)  空间复杂度：O(m + n)  其中 m 和 n 分别为两个链表的长度
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.8 MB, less than 21.55% of Java online submissions for Merge Two Sorted Lists.
     */
}
