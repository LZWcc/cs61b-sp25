package Lec08_Inheritance1;

 /* AList将拥有并定义 List61B 接口中指定的所有属性和行为 */
public class AList<Item> implements List61B<Item> {
    private Item[] items;
    private int size;

    public AList() {
        size = 0;
        items = (Item[]) new Object[100];
    }

    @Override
    public void insert(Item x, int position) {
        Item[] newItems = (Item[]) new Object[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;
    }

    private void resize(int capacity) {
        /* 不应该为new Glorp[capacity]，因为 Glorp 可能是一个接口或抽象类，
           不能直接实例化。使用 Object[] 并在需要时进行类型转换。 */
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        // 将所有元素向后移动一位
        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
        size++;
    }

    @Override
    public Item getFirst() {
        return get(0);
    }

    @Override
    public void addLast(Item x) {
        if (items.length == size) {
            resize(size * 2);
        }
        items[size] = x;
        size++;
    }

    @Override
    // 最后一个元素的索引为 size - 1
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public Item get(int i) {
        if (i >= items.length) {
            throw new IndexOutOfBoundsException();
        }
        return items[i];
    }

    @Override
    public Item removeLast() {
        Item itemToReturn =  getLast();
        items[size - 1] = null; // 清除引用，帮助垃圾回收
        size -= 1;
        return itemToReturn;
    }
}
