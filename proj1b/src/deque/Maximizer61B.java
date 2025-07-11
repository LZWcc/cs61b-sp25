package deque;
import java.util.Comparator;

public class Maximizer61B {
    /**
     * Returns the maximum element from the given iterable of comparables.
     * 从给定的可比较元素的可迭代对象中返回最大元素。
     * You may assume that the iterable contains no nulls.
     * 你可以假设可迭代对象不包含null值。
     *
     * @param iterable  the Iterable of T
     *                  类型T的可迭代对象
     * @return          the maximum element
     *                  最大元素
     */
    public static <T extends Comparable<T>> T max(Iterable<T> iterable) {
        return null;
    }

    /**
     * Returns the maximum element from the given iterable according to the specified comparator.
     * 根据指定的比较器从给定的可迭代对象中返回最大元素。
     * You may assume that the iterable contains no nulls.
     * 你可以假设可迭代对象不包含null值。
     *
     * @param iterable  the Iterable of T
     *                  类型T的可迭代对象
     * @param comp      the Comparator to compare elements
     *                  用于比较元素的比较器
     * @return          the maximum element according to the comparator
     *                  根据比较器确定的最大元素
     */
    public static <T> T max(Iterable<T> iterable, Comparator<T> comp) {
        return null;
    }

    public static void main(String[] args) {
        // The style checker will complain about this main method, feel free to delete.
        // 样式检查器会对这个main方法发出警告，可以随时删除。

        // ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        // ad.addLast(5);
        // ad.addLast(12);
        // ad.addLast(17);
        // ad.addLast(23);
        // System.out.println(max(ad));
    }
}
