package Lec07_lists4.resizeExercise;

public class AList<Item> {
    private Item[] items;
    private int size;

    public AList() {
        size = 0;
        items = (Item[]) new Object[100];
    }

    private void resize(int capacity) {
        /* 不应该为new Glorp[capacity]，因为 Glorp 可能是一个接口或抽象类，
           不能直接实例化。使用 Object[] 并在需要时进行类型转换。 */
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Item x) {
        if (items.length == size) {
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    // 最后一个元素的索引为 size - 1
    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        if (i >= items.length) {
            throw new IndexOutOfBoundsException();
        }
        return items[i];
    }

    public Item removeLast() {
        Item itemToReturn =  getLast();
        items[size - 1] = null; // 清除引用，帮助垃圾回收
        size -= 1;
        return itemToReturn;
    }
}
