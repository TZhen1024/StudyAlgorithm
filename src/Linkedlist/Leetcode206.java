package Linkedlist;

import util.ListNode;

public class Leetcode206 {
    public static void main(String[] args) {

    }
/*    迭代写法 双指针
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head;
        ListNode now = head.next;
        pre.next = null;
        while (now != null) {
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now  = temp;
        }
        return pre;
    }*/

    /*
        递归写法，关键点：
        1. 想清楚如何终止
        2. 想清楚当前层做什么
     */
    /* 第一种递归写法，想得不太清楚
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { // 不用反转的情况
            return head;
        }
        // 递归的想法是，我一次只处理第一个节点和之后所有节点打包的边
        ListNode newHead = reverseList(head.next); // 这里返回的是逆转后的头节点
        ListNode now = newHead;
        head.next = null;
        while (now != null) { // 这里思路是根据逆转后的头节点，找到逆转后的尾节点。这里的写法比较笨，可以替换
            now = now.next;
        }
        now.next = head; // 这里的now.next与下面代码的head.next.next是一样的
        return newHead;
    }*/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
