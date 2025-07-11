package deque;

import java.util.List;

/**
 * Created by hug on 2/4/2017. Methods are provided in the suggested order
 * 由 hug 于 2017年2月4日创建。方法按建议的顺序提供
 * that they should be completed.
 * 它们应该被完成。
 */
public interface Deque61B<T> extends Iterable<T> {

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     * 将 {@code x} 添加到双端队列的前端。假设 {@code x} 永远不为null。
     *
     * @param x item to add
     *          要添加的项
     */
    void addFirst(T x);

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     * 将 {@code x} 添加到双端队列的后端。假设 {@code x} 永远不为null。
     *
     * @param x item to add
     *          要添加的项
     */
    void addLast(T x);

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     * 返回双端队列的List副本。不会改变双端队列。
     *
     * @return a new list copy of the deque.
     *         双端队列的新列表副本。
     */
    List<T> toList();

    /**
     * Returns if the deque is empty. Does not alter the deque.
     * 返回双端队列是否为空。不会改变双端队列。
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     *         如果双端队列没有元素则返回 {@code true}，否则返回 {@code false}。
     */
    boolean isEmpty();

    /**
     * Returns the size of the deque. Does not alter the deque.
     * 返回双端队列的大小。不会改变双端队列。
     *
     * @return the number of items in the deque.
     *         双端队列中项的数量。
     */
    int size();

    /**
     * Remove and return the element at the front of the deque, if it exists.
     * 移除并返回双端队列前端的元素（如果存在）。
     *
     * @return removed element, otherwise {@code null}.
     *         被移除的元素，否则返回 {@code null}。
     */
    T removeFirst();

    /**
     * Remove and return the element at the back of the deque, if it exists.
     * 移除并返回双端队列后端的元素（如果存在）。
     *
     * @return removed element, otherwise {@code null}.
     *         被移除的元素，否则返回 {@code null}。
     */
    T removeLast();

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * Deque61B 抽象数据类型通常没有get方法，
     * but we've included this extra operation to provide you with some
     * 但我们包含了这个额外的操作来为你提供一些
     * extra programming practice. Gets the element, iteratively. Returns
     * 额外的编程练习。迭代地获取元素。返回
     * null if index is out of bounds. Does not alter the deque.
     * null如果索引超出范围。不会改变双端队列。
     *
     * @param index index to get
     *              要获取的索引
     * @return element at {@code index} in the deque
     *         双端队列中索引 {@code index} 处的元素
     */
    T get(int index);

    /**
     * This method technically shouldn't be in the interface, but it's here
     * 这个方法在技术上不应该在接口中，但它在这里
     * to make testing nice. Gets an element, recursively. Returns null if
     * 是为了让测试更好。递归地获取元素。如果
     * index is out of bounds. Does not alter the deque.
     * 索引超出范围则返回null。不会改变双端队列。
     *
     * @param index index to get
     *              要获取的索引
     * @return element at {@code index} in the deque
     *         双端队列中索引 {@code index} 处的元素
     */
    T getRecursive(int index);
}