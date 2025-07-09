package Lec04;

/* Singly Linked List(单链表) */
public class SLList {
    public IntNode first;
    private int size = 0;

    public SLList(int x) {
        first = new IntNode(x, null);
        size++;
    }

    public SLList() {
        first = null;
        size = 0;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size++;
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x) {
        size++;
        if (first == null) {
            first = new IntNode(x, null);
            return;
        }
        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

//    private int size(IntNode p) {
//        if (p.next == null) {
//            return 1;
//        }
//        return 1 + this.size(p.next);
//    }
//
//    public int size() {
//        return size(first);
//    }
}
