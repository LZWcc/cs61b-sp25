package Lec05;

import Lec08_Inheritance1.List61B;

// 单链表实现
/** Single Linked List implementation */
public class SLList<Item> implements List61B<Item> {

    // 节点内部类
    /** Inner Node class */
    private class Node {
        public Item item;
        public Node next;

        public Node(Item i, Node n) {
            item = i;
            next = n;
        }
    }

    private Node sentinel; // 哨兵节点
    private int size;      // 列表大小
    private Node last;     // 指向最后一个节点

    // 创建空的单链表
    /** Creates an empty single linked list */
    public SLList() {
        sentinel = new Node(null, null);
        last = sentinel;
        size = 0;
    }

    // 在指定位置插入元素
    /** Inserts item at the given position */
    public void insert(Item x, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        Node current = sentinel;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        Node newNode = new Node(x, current.next);
        current.next = newNode;

        if (position == size) {
            last = newNode;
        }
        size++;
    }

    // 在列表头部添加元素
    /** Adds item to the front of the list */
    public void addFirst(Item x) {
        sentinel.next = new Node(x, sentinel.next);
        if (size == 0) {
            last = sentinel.next;
        }
        size++;
    }

    // 在列表尾部添加元素
    /** Adds item to the back of the list */
    public void addLast(Item x) {
        Node newNode = new Node(x, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    // 获取第一个元素
    /** Returns the first item in the list */
    public Item getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return sentinel.next.item;
    }

    // 获取最后一个元素
    /** Returns the last item in the list */
    public Item getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return last.item;
    }

    // 获取指定位置的元素
    /** Gets the ith item in the list (0 is the front) */
    public Item get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = sentinel.next;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.item;
    }

    // 删除并返回最后一个元素
    /** Deletes item from back of the list and returns deleted item */
    public Item removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        if (size == 1) {
            Item item = last.item;
            sentinel.next = null;
            last = sentinel;
            size--;
            return item;
        }

        // 找到倒数第二个节点
        Node current = sentinel;
        while (current.next.next != null) {
            current = current.next;
        }

        Item item = current.next.item;
        current.next = null;
        last = current;
        size--;
        return item;
    }

    // 返回列表大小
    /** Returns the number of items in the list */
    public int size() {
        return size;
    }
}
