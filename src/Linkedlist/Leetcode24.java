package Linkedlist;

import util.ListNode;

public class Leetcode24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        /*
        递归写法：
        1. 当链表中只有0或1个元素时直接返回
        2. 当前层只做相邻两个元素之间的交换，将后面的打包看待

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        head.next = swapPairs(cur.next);
        cur.next = head;
        return cur;
        */

        /*
            迭代写法
         */
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(); // 因为前一对节点和后一对节点之间存在关系
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        while (pre.next != null && pre.next.next != null) {
            cur = pre.next;
            next = pre.next.next;
            cur.next = next.next; // 注意先处理未用变量指示的节点，这里是next.next, 如果不先处理这个，而是改变了next.next, 那么原来的就找不到了
            next.next = cur; // 上一句使用完了什么，这一句就可以更改什么
            pre.next = next;
            pre = cur;
        }
        return dummy.next;
    }
}
