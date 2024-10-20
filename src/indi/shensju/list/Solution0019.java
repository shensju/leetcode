package indi.shensju.list;

import java.util.Stack;

/**
 * @author shensju
 * @date 2021/3/16 23:15
 * 0019 Remove Nth Node From End of List 删除链表的倒数第 N 个结点
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

    /** 方法一：计算链表长度，时间复杂度 O(n)，空间复杂度 O(1) **/
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /** 方法二：栈，时间复杂度 O(n)，空间复杂度 O(n) **/
    public ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = dummy;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    /** 方法三：双指针，时间复杂度 O(n)，空间复杂度 O(1) **/
    public ListNode removeNthFromEnd03(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
