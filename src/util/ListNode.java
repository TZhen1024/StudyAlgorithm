package util;

import java.util.List;

// Leetcode definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode generateListFromArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        ListNode dummyNode = new ListNode();
        ListNode head = new ListNode(nums[0]);
        dummyNode.next = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode now = new ListNode(nums[i]);
            head.next = now;
            head = now;
        }
        return dummyNode.next;
    }
}
