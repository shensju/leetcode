/**
 * @Author: shensju
 * @Date: 2021/3/23 23:29
 */
public class Solution0082 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0082 Remove Duplicates from Sorted List II **/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        ListNode curr = prev.next;
        while (curr != null) {
            ListNode detect = curr;
            int repeateNum = 0;
            while (detect != null && detect.val == curr.val) {
                detect = detect.next;
                repeateNum++;
            }
            if (repeateNum > 1) {
                prev.next = detect;
            } else {
                prev = curr;
            }
            curr = detect;
        }
        return dummyNode.next;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
     * Memory Usage: 38.2 MB, less than 83.54% of Java online submissions for Remove Duplicates from Sorted List II.
     */
}
