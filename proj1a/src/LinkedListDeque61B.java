import java.util.List;
import java.util.ArrayList; // import the ArrayList class

public class LinkedListDeque61B<T> implements Deque61B<T> {
    public Node sentinel;
    public int size = 0;

    public class Node {
        public T item;
        public Node next;
        public Node prev;
        /* 构造 i 为元素, next为下一个节点 */
        public Node(T i, Node next, Node prev) {
            this.item = i;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /* sentinel <--> newNode <--> sentinel */
    public LinkedListDeque61B(T x) {
        sentinel = new Node(null, null, null);
        Node newNode = new Node(x, sentinel, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
    }

    @Override
    public void addFirst(T x) {
        /* 新节点的next为sentinel.next, 前一个节点为sentinel */
        Node newNode = new Node(x, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel;
        int i = 0;
        while (p.next != sentinel) {
            p = p.next;
            returnList.add(p.item);
        }
        // return List.of();
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return first.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node last = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last.item;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node p = sentinel;
        int cnt = 0;
        while (p.next != sentinel) {
            p = p.next;
            if (cnt == index) {
                return p.item;
            }
            cnt++;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
