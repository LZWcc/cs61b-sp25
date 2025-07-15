import java.util.Iterator;
import java.util.Set;

/** A data structure that uses a linked list to store pairs of keys and values.
 *  使用链表来存储键值对的数据结构。
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  任何键在字典中最多只能出现一次，但值可以出现多次。
 *  times. Key operations are get(key), put(key, value), and contains(key) methods. The value
 *  主要操作包括get(key)、put(key, value)和contains(key)方法。
 *  associated to a key is the value in the last call to put with that key.
 *  与键关联的值是最后一次调用put方法时传入的值。 */
public class ULLMap<K, V>  implements Map61B<K, V> {

    int size = 0;

    /** Returns the value corresponding to KEY or null if no such value exists. */
    /** 返回与KEY对应的值，如果不存在则返回null。 */
    public V get(K key) {
        if (list == null) {
            return null;
        }
        Entry lookup = list.get(key);
        if (lookup == null) {
            return null;
        }
        return lookup.val;
    }

    @Override
    public int size() {
        return size;
    }

    /** Removes all of the mappings from this map. */
    /** 从该映射中移除所有映射关系。 */
    @Override
    public void clear() {
        size = 0;
        list = null;
    }

    /** Inserts the key-value pair of KEY and VALUE into this dictionary,
     *  将KEY和VALUE的键值对插入到该字典中，
     *  replacing the previous value associated to KEY, if any.
     *  如果存在，则替换之前与KEY关联的值。 */
    public void put(K key, V val) {
        if (list != null) {
            Entry lookup = list.get(key);
            if (lookup == null) {
                list = new Entry(key, val, list);
            } else {
                lookup.val = val;
            }
        } else {
            list = new Entry(key, val, list);
            size = size + 1;
        }
    }

    /** Returns true if and only if this dictionary contains KEY as the
     *  当且仅当该字典包含KEY作为某个键值对的键时返回true
     *  key of some key-value pair. */
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

    /** Keys and values are stored in a linked list of Entry objects.
     *  键和值存储在Entry对象的链表中。
     *  This variable stores the first pair in this linked list.
     *  该变量存储链表中的第一对键值对。 */
    private Entry list;

    /** Represents one node in the linked list that stores the key-value pairs
     *  表示链表中存储键值对的一个节点
     *  in the dictionary. */
    private class Entry {

        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  将KEY存储为该键值对中的键，VAL作为值，
         *  NEXT as the next node in the linked list.
         *  NEXT作为链表中的下一个节点。 */
        Entry(K k, V v, Entry n) {
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  返回该键值对链表中键等于KEY的Entry，
         *  is equal to KEY, or null if no such Entry exists.
         *  如果不存在这样的Entry则返回null。 */
        Entry get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (next == null) {
                return null;
            }
            return next.get(key);
        }

        /** Stores the key of the key-value pair of this node in the list. */
        /** 存储列表中该节点键值对的键。 */
        K key;
        /** Stores the value of the key-value pair of this node in the list. */
        /** 存储列表中该节点键值对的值。 */
        V val;
        /** Stores the next Entry in the linked list. */
        /** 存储链表中的下一个Entry。 */
        Entry next;

    }

    /** An iterator that iterates over the keys of the dictionary. */
    /** 一个迭代器，用于遍历字典的键。 */
    private class ULLMapIter implements Iterator<K> {

        /** Create a new ULLMapIter by setting cur to the first node in the
         *  通过将cur设置为存储键值对的链表中的第一个节点来创建新的ULLMapIter
         *  linked list that stores the key-value pairs. */
        public ULLMapIter() {
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

        /** Stores the current key-value pair. */
        /** 存储当前的键值对。 */
        private Entry cur;

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
