package Lec05;

import Lec04.IntNode;

public class SLList {
    private IntNode sentinel;
    private int size;
    private IntNode last;

    public SLList(int x) {
        sentinel = new IntNode(547, null);
        size++;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }
    public void addLast(int x) {
        last.next = new IntNode(x, null);
        last = last.next;
        size += 1;
    }
}
