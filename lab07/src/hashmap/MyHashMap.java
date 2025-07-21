package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 *
 *  一个基于哈希表的Map实现。
 *
 *  假设永远不会插入null键，并且在删除时不会缩小大小。
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {
    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     *
     * 受保护的辅助类，用于存储键值对
     * protected限定符允许子类访问
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables
     * 实例变量
     */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    // 你可能应该定义更多的实例变量！

    int size = 0;
    private int initialCapacity;
    private double loadFactor;
    private double resizingFactor = 1.5;
    /** Constructors
     *  构造函数
     */

    public MyHashMap() {
        initialCapacity = 16;
        loadFactor = 0.75;
        initializeBuckets();
    }

    public MyHashMap(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        loadFactor = 0.75;
        initializeBuckets();
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor maximum load factor
     *
     * MyHashMap构造函数，创建一个大小为initialCapacity的底层数组。
     * 负载因子（元素数量 / 桶数量）应该始终 <= loadFactor
     *
     * @param initialCapacity 底层数组的初始大小
     * @param loadFactor 最大负载因子
     */
    /* 当前负载因子 =  元素数量N(size) / 桶数量M */
    public MyHashMap(int initialCapacity, double loadFactor) {
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        initializeBuckets();
    }

    private void initializeBuckets() {
        buckets = new Collection[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            buckets[i] = createBucket();
        }
    }

    private void resize() {
        int newCapacity = (int) (1.5 * buckets.length);
        Collection<Node>[] newBuckets = new Collection[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = createBucket();
        }

        for (Collection<Node> bucket : buckets) {
            for (Node node : bucket) {
                int newIdx = Math.floorMod(node.key.hashCode(), newCapacity);
                newBuckets[newIdx].add(node);
            }
        }
        this.buckets = newBuckets;
    }

    private int getBucketIndex(K key) {
        return Math.floorMod(key.hashCode(), buckets.length);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *  Note that that this is referring to the hash table bucket itself,
     *  not the hash map itself.
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     *
     * 返回一个作为哈希表桶的数据结构
     *
     * 哈希表桶的唯一要求是我们能够：
     *  1. 插入元素（`add`方法）
     *  2. 删除元素（`remove`方法）
     *  3. 遍历元素（`iterator`方法）
     *  注意这里指的是哈希表桶本身，
     *  而不是哈希映射本身。
     *
     * 这些方法都由java.util.Collection支持，
     * Java中的大多数数据结构都继承自Collection，所以我们
     * 可以使用几乎任何数据结构作为我们的桶。
     *
     * 重写此方法以使用不同的数据结构作为
     * 底层桶类型
     *
     * 确保调用此工厂方法，而不是使用NEW操作符
     * 创建自己的桶数据结构！
     */
    protected Collection<Node> createBucket() {
        // TODO: Fill in this method.
        // TODO: 填写此方法。
        return new LinkedList<>();
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    // TODO: 在下面实现Map61B接口的方法
    // 在你这样做之前，你的代码不会编译！
    @Override
    public void put(K key, V value) {
        int buckerIndex = getBucketIndex(key);
        Collection<Node> bucket = buckets[buckerIndex];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return ;
            }
        }
        bucket.add(new Node(key, value));
        size++;

        if ((double) size / buckets.length > loadFactor) {
            resize();
        }
    }

    @Override
    public V get(K key) {
        if (!containsKey(key)) {
            return null;
        }
        int buckerIndex = getBucketIndex(key);
        Collection<Node> bucket = buckets[buckerIndex];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int buckerIndex = getBucketIndex(key);
        Collection<Node> bucket = buckets[buckerIndex];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        initializeBuckets();
    }

    /* Optional - 使用ChatGPT辅助编写 */
    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (K key : this) {
            keySet.add(key);
        }
        return keySet;
    }

    @Override
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Collection<Node> bucket = buckets[bucketIndex];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                V removedValue = node.value;
                bucket.remove(node);
                size--;
                return removedValue;
            }
        }
        return null;
    }

    public V remove(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Collection<Node> bucket = buckets[bucketIndex];
        for(Node node : bucket) {
            // 不使用node.value.equals(value)
            // 危险：如果 node.value 是 null，会抛出 NullPointerException
            if (node.key.equals(key) && Objects.equals(node.value, value)) {
                bucket.remove(node);
                size--;
                return value;
            }
        }
        return null;
    }

    private class MyHashMapIterator implements Iterator<K> {
        private int bucketIndex = 0;
        private Iterator<Node> bucketIterator = buckets[0].iterator();
        private void advance() {
            //            当前桶在索引范围内             桶迭代器没有下一个元素
            while (bucketIndex < buckets.length && !bucketIterator.hasNext()) {
                bucketIndex++;
                if (bucketIndex < buckets.length) {
                    // 获取新桶的迭代器
                    bucketIterator = buckets[bucketIndex].iterator();
                }
            }
        }

        @Override
        public boolean hasNext() {
            advance();
            return bucketIndex < buckets.length;
        }

        @Override
        public K next() {
            advance();
            if (bucketIndex >= buckets.length) {
                throw new NoSuchElementException();
            }
            return bucketIterator.next().key;
        }
    }

    @Override
    public Iterator<K> iterator() {
        // throw new UnsupportedOperationException();
        return new MyHashMapIterator();
    }
}
