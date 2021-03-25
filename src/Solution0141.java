import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shensju
 * @Date: 2021/3/24 23:46
 */
public class Solution0141 {

    /** Definition for singly-linked list **/
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** 0141 Linked List Cycle **/

    /** 方法一：哈希表 **/
    public boolean hasCycle01(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * Runtime: 4 ms, faster than 10.31% of Java online submissions for Linked List Cycle.
     * Memory Usage: 39.6 MB, less than 45.17% of Java online submissions for Linked List Cycle.
     */

    /** 方法二：快慢指针 **/
    public boolean hasCycle02(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 40.1 MB, less than 44.05% of Java online submissions for Linked List Cycle.
     */
}
