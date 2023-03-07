package Linkedlist;

import util.ListNode;

public class Leetcode142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head.next.next;

        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null)
            return null;

        int len = 1;
        fast = fast.next;
        while (slow != fast) {
            fast = fast.next;
            len++;
        }

        slow = fast = head;
        for (int i = 0; i < len; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
