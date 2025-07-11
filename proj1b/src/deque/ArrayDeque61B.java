package deque;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    @Override
    /**
     * nextFirst指向当前元素存放的位置
     * 调用addFirst时, 先把值赋给item, 再进行nextFirst -= 1
     */
    public void addFirst(T x) {
        checkResize();
        items[nextFirst] = x;
        nextFirst = returnCorrectIndex(nextFirst - 1);
        size++;
    }

    @Override
    public void addLast(T x) {
        checkResize();
        items[nextLast] = x;
        nextLast = returnCorrectIndex(nextLast + 1);
        size++;
    }

    private int returnCorrectIndex(int x) {
        return Math.floorMod(x, items.length);
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            returnList.add(get(i));
        }
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
        if (isEmpty()) {
            return null;
        }
        int firstIndex = returnCorrectIndex(nextFirst + 1);
        T temp = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size--;
        checkResize();
        return temp;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int lastIndex = returnCorrectIndex(nextLast - 1);
        T temp = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;
        size--;
        checkResize();
        return temp;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        // 先得到当前元素的索引为nextFirst + 1;
        int temp = returnCorrectIndex(nextFirst + 1);
        return items[returnCorrectIndex(index + temp)];
    }

    @Override
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int temp = returnCorrectIndex(nextFirst + 1);
        return items[returnCorrectIndex(index + temp)];
    }

    private void resizingUp() {
        T[] temp = (T[]) new Object[items.length * 2];
        int p = returnCorrectIndex(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            temp[i] = items[returnCorrectIndex(p + i)];
        }
        items = temp;
        // 把 nextFirst 指向新数组的最后一个位置，表示下次 addFirst 时会从这里插入
        nextFirst = items.length - 1;
        // 把 nextLast 指向当前队列末尾的下一个空位（即已有元素数量的位置），方便下次 addLast 插入。
        nextLast = size;
    }

    private void resizingDown() {
        T[] temp = (T[]) new Object[items.length / 2];
        int p = returnCorrectIndex(nextFirst + 1);
        for (int i = 0; i < size; i++) {
            temp[i] = items[returnCorrectIndex(p + i)];
        }
        items = temp;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void checkResize() {
        if (size == items.length) {
            resizingUp();
        } else if (size > 0 && size <= items.length / 4 && size >= 16) {
            resizingDown();
        }
    }
}
