package list;

/**
 * @author shensju
 * @date 2024/4/14 16:00
 * 0876 Middle of the Linked List 链表的中间结点
 */
public class Solution0876 {
    /** 快慢指针，时间复杂度 O(n)，空间复杂度 O(1) **/
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
