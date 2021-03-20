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
        if(head == null || k == 0) return head;
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        int count = 0;
        while(prev.next != null) {
            prev = prev.next;
            count++;
        }
        // 实际将链表每个节点向右移动的位置
        k = k % count;
        if(k == 0) return head;
        prev = dummyNode;
        for(int i = 0; i < count - k; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        prev.next = null;

        ListNode temp = dummyNode.next;
        dummyNode.next = curr;

        for(int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }
        curr.next = temp;
        return dummyNode.next;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 1 ms, faster than 34.00% of Java online submissions for Rotate List.
     * Memory Usage: 39.4 MB, less than 17.46% of Java online submissions for Rotate List.
     */
}
