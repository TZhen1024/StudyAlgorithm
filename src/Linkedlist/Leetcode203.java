package Linkedlist;

import util.ListNode;

public class Leetcode203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode now = head, pre = dummy;
        while (now != null) {
            if (now.val != val) {
                now = now.next;
                pre = pre.next;
            } else {
                pre.next = now.next;
                now.next = null;
                now = pre.next;
            }
        }
        return dummy.next;
    }
}
