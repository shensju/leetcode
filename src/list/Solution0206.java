package list;

/**
 * @author shensju
 * @date 2021/3/17 23:24
 * 0206 Reverse Linked List 反转链表
 */
public class Solution0206 {
    /** 方法一：迭代，时间复杂度 O(n)，空间复杂度 O(1) **/
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

    /** 方法二：递归，时间复杂度 O(n)，空间复杂度 O(n) **/
    public ListNode reverseList02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList02(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
