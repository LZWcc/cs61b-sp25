package Lec08_Inheritance1;

// 这是一个接口，不能直接实例化
public interface List61B<Item> {
    public void insert(Item x, int position);
    public void addFirst(Item x);
    public void addLast(Item x);
    public Item getFirst();
    public Item getLast();
    public Item get(int i);
    public Item removeLast();
}
