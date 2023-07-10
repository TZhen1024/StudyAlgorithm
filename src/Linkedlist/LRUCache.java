package Linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

// Leetcode146
public class LRUCache {
    // HashMap来保证get和put操作的O(1)平均时间复杂度，用链表存储关键字key，来指示其存在和淘汰

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {};
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
    HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) { // 关键字不存在，插入key-value
            DLinkedNode newNode = new DLinkedNode(key, value);
            insertToHead(newNode);
        } else {
            moveToHead(node);
            node.value = value;
        }
    }

    public void moveToHead(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        DLinkedNode temp = head.next;
        node.next = temp;
        temp.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void insertToHead(DLinkedNode node) {
        if (cache.size() >= capacity) {
            removeTail();
        }
        DLinkedNode temp = head.next;
        node.next = temp;
        temp.prev = node;
        head.next = node;
        node.prev = head;
        cache.put(node.key, node);
    }

    public void removeTail() {
        DLinkedNode temp = tail.prev.prev;
        cache.remove(temp.next.key);
        temp.next = tail;
        tail.prev = temp;

    }
}
