package Lec10_inheritance3;

import java.util.Iterator;

public class ArraySet<T> implements Iterator<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items =(T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (!contains(x)) {
            items[size] = x;
            size += 1;
        }
    }

    private class ArraySetIterator implements Iterable<T> {
        // 指向的位置
        private int wizPos;

        ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            if (wizPos < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            // returns the item
            T itemToReturn = items[wizPos];

            // advances
            wizPos += 1;

            return itemToReturn;
        }
    }

    public Iterator<T> iterator() {
        return  new ArraySetIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ArraySet uddaSet) {
            // ArraySet uddaSet  = an arraySet version of o
            // 如果o是数组集合实例, 有了实例uddaSet
            // 它饿类型也是ArraySet
            if (this.size != uddaSet.size()) {
                return false;
            }
            for (T x : this) {
                if (!uddaSet.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        Iterator<Integer> aseer = aset.iterator();
        while (aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }
    }
}