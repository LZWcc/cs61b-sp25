package hashmap;

import java.util.Iterator;
import java.util.Set;

/**
 * A data structure that uses a linked list to store pairs of keys and values.
 * Any key must appear at most once in the dictionary, but values may appear multiple
 * times. Key operations are get(key), put(key, value), and contains(key) methods. The value
 * associated to a key is the value in the last call to put with that key.
 *
 * 一个使用链表存储键值对的数据结构。
 * 任何键在字典中最多只能出现一次，但值可以出现多次。
 * 主要操作是get(key)、put(key, value)和contains(key)方法。
 * 与键关联的值是最后一次调用put方法时使用该键的值。
 */
public class ULLMap<K, V>  implements Map61B<K, V> {
    int size = 0;

    /** Returns the value corresponding to KEY or null if no such value exists.
     *
     * 返回与KEY对应的值，如果不存在这样的值则返回null。
     */
    public V get(K key) {
        if (list == null) {
            return null;
        }
        Node lookup = list.get(key);
        if (lookup == null) {
            return null;
        }
        return lookup.val;
    }

    @Override
    public int size() {
        return size;
    }

    /** Removes all of the mappings from this map.
     *
     * 从此映射中删除所有映射。
     */
    @Override
    public void clear() {
        size = 0;
        list = null;
    }

    /**
     * Inserts the key-value pair of KEY and VALUE into this map,
     * replacing the previous value associated to KEY, if any.
     *
     * 将KEY和VALUE的键值对插入此映射中，
     * 如果存在与KEY关联的先前值，则替换它。
     */
    public void put(K key, V val) {
        if (list != null) {
            Node lookup = list.get(key);
            if (lookup == null) {
                list = new Node(key, val, list);
                size = size + 1;
            } else {
                lookup.val = val;
            }
        } else {
            list = new Node(key, val, list);
            size = size + 1;
        }
    }

    /**
     * Returns true if and only if this dictionary contains KEY as the
     * key of some key-value pair.
     *
     * 当且仅当此字典包含KEY作为某个键值对的键时返回true。
     */
    public boolean containsKey(K key) {
        if (list == null) {
            return false;
        }
        return list.get(key) != null;
    }

    @Override
    public Iterator<K> iterator() {
        return new ULLMapIter();
    }

    /**
     * Keys and values are stored in a linked list of Node objects.
     * This variable stores the first Node in this linked list.
     *
     * 键和值存储在Node对象的链表中。
     * 此变量存储链表中的第一个Node。
     */
    private Node list;

    /**
     * Represents one node in the linked list that stores the key-value pairs
     * in the dictionary.
     *
     * 表示链表中存储字典中键值对的一个节点。
     */
    private class Node {

        /**
         * Stores KEY as the key in this key-value pair, VAL as the value, and
         * NEXT as the next node in the linked list.
         *
         * 将KEY存储为此键值对中的键，VAL作为值，
         * NEXT作为链表中的下一个节点。
         */
        Node(K k, V v, Node n) {
            key = k;
            val = v;
            next = n;
        }

        /**
         * Returns the Node in this linked list of key-value pairs whose key
         * is equal to KEY, or null if no such Node exists.
         *
         * 返回此键值对链表中键等于KEY的Node，
         * 如果不存在这样的Node则返回null。
         */
        Node get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (next == null) {
                return null;
            }
            return next.get(k);
        }

        /** Stores the key of the key-value pair of this node in the list.
         * 存储列表中此节点的键值对的键。
         */
        K key;
        /** Stores the value of the key-value pair of this node in the list.
         * 存储列表中此节点的键值对的值。
         */
        V val;
        /** Stores the next Node in the linked list.
         * 存储链表中的下一个Node。
         */
        Node next;

    }

    /** An iterator that iterates over the keys of the dictionary.
     *
     * 遍历字典键的迭代器。
     */
    private class ULLMapIter implements Iterator<K> {

        /**
         * Create a new ULLMapIter by setting cur to the first node in the
         * linked list that stores the key-value pairs.
         *
         * 通过将cur设置为存储键值对的链表中的第一个节点
         * 来创建新的ULLMapIter。
         */
        ULLMapIter() {
            cur = list;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public K next() {
            K ret = cur.key;
            cur = cur.next;
            return ret;
        }


        /** Stores the current key-value pair.
         * 存储当前的键值对。
         */
        private Node cur;

    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

}
