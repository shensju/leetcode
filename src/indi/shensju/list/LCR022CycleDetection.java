package indi.shensju.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shensju
 * @date 2024/4/16 23:01
 * LCR 022 CycleDetection 单向链表的环路检测
 */
public class LCR022CycleDetection {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 快慢指针，判断是否有环路，时间复杂度 O(n)，空间复杂度 O(1) **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /** 哈希表，返回环路的开始结点，时间复杂度 O(n)，空间复杂度 O(n) **/
    public ListNode detectCycle01(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /** 快慢指针，返回环路的开始结点，时间复杂度 O(n)，空间复杂度 O(1) **/
    public ListNode detectCycle02(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
