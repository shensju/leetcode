package list;

/**
 * @author shensju
 * @date 2024/4/14 15:53
 * singly-linked list 单向链表
 */
public class ListNode {

    protected int val;

    protected ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
