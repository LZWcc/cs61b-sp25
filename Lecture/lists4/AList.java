// 基于数组的列表。
/** Array based list.
 *  @author Josh Hug
 */
package lists4;
public class AList {
    private int[] items;
    private int size;
    // 创建一个空列表。
    /** Creates an empty list. */
    public AList() {
        items = new int[2000010];
        size = 0;
    }

    // 在列表末尾插入X。
    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        items[size] = x;
        size++;
    }

    // 返回列表末尾的元素。
    /** Returns the item from the back of the list. */
    public int getLast() {
        int Last = items[size - 1];
        return Last;
    }
    // 获取列表中第i个元素（0为前端）。
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    // 返回列表中的元素数量。
    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    // 删除并返回列表末尾的元素。
    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int itemToReturn = getLast();
        size--;
        return itemToReturn;
    }
}
