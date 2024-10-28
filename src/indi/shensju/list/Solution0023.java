package indi.shensju.list;

import java.util.PriorityQueue;

/**
 * @author shensju
 * @date 2024/10/28 21:01
 * 0023 Merge k Sorted Lists 合并 K 个升序链表
 */
public class Solution0023 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 方法一：顺序合并，时间复杂度 O(k^2*n)，空间复杂度 O(1) **/
    public ListNode mergeKLists01(ListNode[] lists) {
        ListNode res = null;
        int k = lists.length;
        for (int i = 0; i < k; i++) {
            res = mergeTwooLists(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeTwooLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }
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
        tail.next = (list1 != null ? list1 : list2);
        return dummy.next;
    }

    /** 方法二：分治合并，时间复杂度 O(kn*logk)，空间复杂度 O(logk) **/
    public ListNode mergeKLists02(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l >= r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwooLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /** 方法三：使用优先队列合并，时间复杂度 O(kn*logk)，空间复杂度 O(k) **/
    public ListNode mergeKLists03(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            tail.next = status.node;
            tail = tail.next;
            if (status.node.next != null) {
                queue.offer(new Status(status.node.next.val, status.node.next));
            }
        }
        return dummy.next;
    }

    static class Status implements Comparable<Status> {
        int val;
        ListNode node;

        public Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status status) {
            return this.val - status.val;
        }
    }
}
