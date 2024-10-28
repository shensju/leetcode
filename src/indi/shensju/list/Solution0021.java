package indi.shensju.list;

/**
 * @author shensju
 * @date 2021/03/14 23:32
 * 0021 Merge Two Sorted Lists 合并两个有序链表
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

    /** 方法一：递归，时间复杂度 O(m+n)，空间复杂度 O(m+n)，其中 m 和 n 分别为两个链表的长度 **/
    public ListNode mergeTwoLists01(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists01(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists01(list1, list2.next);
            return list2;
        }
    }

    /** 方法二：迭代，时间复杂度 O(m+n)，空间复杂度 O(1)，其中 m 和 n 分别为两个链表的长度 **/
    public ListNode mergeTwoLists02(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}
