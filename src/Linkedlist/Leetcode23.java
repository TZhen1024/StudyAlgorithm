package Linkedlist;

import util.ListNode;

public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];
        ListNode head = lists[0];
        for (int i = 1; i < n; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // 将head2链表合并到head1链表中
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode newHead2 = head2.next;
        if (head1.val >= head2.val) { // head2插到head1前面
            head2.next = head1;
            return mergeTwoLists(head2, newHead2);
        } else { // head2.val > head1.val, 所以要往后看直到找到一个比head2.val大的，查到它前面
            ListNode pre = head1;
            ListNode temp = head1.next; // 其实temp可以直接用pre.next代替，这里方便看清楚
            while (temp != null && temp.val < head2.val) {
                temp = temp.next;
                pre = pre.next;
            }
            head2.next = pre.next;
            pre.next = head2;
            return mergeTwoLists(head1, newHead2);
        }
    }
}
