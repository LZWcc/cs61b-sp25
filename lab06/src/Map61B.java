import java.util.Set;

/* Your implementation BSTMap should implement this interface. To do so,
 * 你的BSTMap实现应该实现这个接口。为此，
 * append "implements Map61B<K, V>" to the end of your "public class..."
 * 在你的"public class..."声明的末尾添加"implements Map61B<K, V>"，
 * declaration, though you can and should use other type parameters when
 * 尽管在必要时你可以并且应该使用其他类型参数。
 * necessary.
 */
public interface Map61B<K, V> extends Iterable<K> {

    /** Associates the specified value with the specified key in this map.
     *  将指定的值与此映射中的指定键关联。
     *  If the map already contains the specified key, replaces the key's mapping
     *  如果映射已经包含指定的键，则用指定的值替换键的映射
     *  with the value specified. */
    void put(K key, V value);

    /** Returns the value to which the specified key is mapped, or null if this
     *  返回指定键映射到的值，如果此映射不包含该键的映射则返回null
     * map contains no mapping for the key. */
    V get(K key);

    /** Returns whether this map contains a mapping for the specified key. */
    /** 返回此映射是否包含指定键的映射。 */
    boolean containsKey(K key);

    /** Returns the number of key-value mappings in this map. */
    /** 返回此映射中键值映射的数量。 */
    int size();

    /** Removes every mapping from this map. */
    /** 从此映射中移除所有映射。 */
    void clear();

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     *  返回此映射中包含的键的Set视图。Lab 7不需要此方法。
    /** If you don't implement this, throw an UnsupportedOperationException. */
    /* 如果你不实现此方法，抛出UnsupportedOperationException。 */
    Set<K> keySet();

    /** Removes the mapping for the specified key from this map if present,
     *  如果存在，从此映射中移除指定键的映射，
     * or null if there is no such mapping.
     * 如果没有这样的映射则返回null。
     * Not required for Lab 7. If you don't implement this, throw an
     * Lab 7不需要此方法。如果你不实现此方法，抛出
     * UnsupportedOperationException. */
    V remove(K key);
}
