package Linkedlist;

import util.ListNode;

public class Leetcode25 {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 函数功能：k个一组翻转，返回翻转后的链表头节点
        // 每层递归就是把当前层需要考虑的节点摘出来进行处理

        ListNode nextGroupHead = head;
        for (int i = 0; i < k; i++) {
            if (nextGroupHead == null) {
                return head;
            } else {
                nextGroupHead = nextGroupHead.next;
            }
        }

        ListNode pre, now, next;
        pre = null;
        now = head;
        next = head.next;

        while (next != nextGroupHead) { // nextGroupHead可能为null
           now.next = pre; // 改变链接方向
           pre = now; // 依次后移
           now = next;
           next = next.next;
        }
        now.next = pre; // 至此 当前层负责的部分链表反转完毕
        head.next = reverseKGroup(nextGroupHead, k);

        return now;

    }
}
