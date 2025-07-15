import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
//    int size = 0;
//    private K key;
//    private V value;
//    private BSTMap left;
//    private BSTMap right;
//
//    public BSTMap(K key, V value, BSTMap left, BSTMap right) {
//        this.key = K;
//        this.left = left;
//        this.right = right;
//        this.value = value;
//    }
//
//    private BSTMap root;
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;
    private int size = 0;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        // 递归走到底, 创建一个新节点
        if (node == null) {
            size += 1;
            return new Node(key, value);
        }
        /* 使用插入的键 key 和当前节点的键 node.key 比较大小 */
        int cmp = key.compareTo(node.key);
        /* key < node.key, 插入到左子树 */
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        /* 把当前这棵子树的根节点继续返回给上一级递归调用 */
        return node;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            // node.left = get(node.left, key); 不是改变结构, 需要直接return
            return get(node.left, key);
        } else if (cmp > 0) {
            // node.right = get(node.right, key);
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public boolean containsKey(K key) {
        // return get(key) != null;
        /* 即使 value 是 null 也能判断 key 存在性 */
        return containsKey(root, key);
    }

    private boolean containsKey(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return containsKey(node.left, key);
        } else if (cmp > 0) {
            return containsKey(node.right, key);
        } else {
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    /* 以上为必须实现的方法 */

    /* Optional */
    @Override
    public Set<K> keySet() {
        // return Set.of();
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}