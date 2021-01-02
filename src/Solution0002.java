/**
 * @Author: shensju
 * @Date: 2021/1/2 17:47
 */

public class Solution0002 {
    /*Definition for singly-linked list*/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            // 申明数值
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            // 计算数值
            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            current.next = new ListNode(val);
            // 更新数值
            current = current.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
}
