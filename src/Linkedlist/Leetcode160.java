package Linkedlist;

import util.ListNode;

public class Leetcode160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 这里的想法是，让长的一个链走完先走两链长度之差的距离，那么两个指针就会同时走到交叉点
        // 但是这里的实现方式不如Leetcode官解
        // 可以这么想，两个指针，分别走一条链走完之后跳到另一条链，那么走到交点的时候，两个指针走了相同的距离
        int lengthA = 0, lengthB = 0;
        ListNode nowA = headA, nowB = headB;

        while (nowA != null) {
            lengthA++;
            nowA = nowA.next;
        }
        while (nowB != null) {
            lengthB++;
            nowB = nowB.next;
        }

        int diff = 0;
        nowA = headA;
        nowB = headB;
        if (lengthA >= lengthB) {
            diff = lengthA - lengthB;
            while ((diff--) > 0)
                nowA = nowA.next;
        } else {
            diff = lengthB - lengthA;
            while ((diff--) > 0)
                nowB = nowB.next;
        }

        while (nowA != nowB) {
            nowA = nowA.next;
            nowB = nowB.next;
        }

        return nowA;
    }
}
