package Linkedlist;

public class Leetcode707 {
    public static void main(String[] args) {
        Leetcode707 linkedList = new Leetcode707();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }

    public class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) {this.val = val;}
        Node(int val, Node next) {this.val = val; this.next = next; }
    }

    Node head = null;
    int length = 0;
    public Leetcode707() {

    }

    public int get(int index) {
        if (index < 0 || index >= this.length)
            return -1;
        Node now = this.head;
        while (index > 0) {
            now = now.next;
            index--;
        }
        return now.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void addAtTail(int val) {
        if (this.head == null) {
            addAtHead(val);
            return;
        }
        Node now = this.head;
        while (now.next != null) {
            now = now.next;
        }
        now.next = new Node(val);
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        } else if (index == this.length) {
            addAtTail(val);
            return;
        } else if (index < this.length) {
            Node now = this.head;
            Node newNode = new Node(val);
            while (index > 1) {
                now = now.next;
                index--;
            }
            newNode.next = now.next;
            now.next = newNode;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < this.length) {
            Node dummy = new Node(0, this.head);
            Node now = dummy;
            while (index > 0) {
                now = now.next;
                index--;
            }
            now.next = now.next.next;
            length--;
            this.head = dummy.next;
        }
    }
}
