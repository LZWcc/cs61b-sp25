package hashmap;

import java.util.Map;
import java.util.Set;

/* Your implementation should implement this interface. To do so,
 * append "implements Map61B<K, V>" to the end of your "public class..."
 * declaration, though you can and should use other type parameters when
 * necessary.
 *
 * 你的实现应该实现这个接口。为此，请在你的"public class..."声明的末尾
 * 添加"implements Map61B<K, V>"，不过你可以并且应该在必要时使用其他类型参数。
 */
public interface Map61B<K, V> extends Iterable<K> {

    /** Associates the specified value with the specified key in this map.
     *  If the map already contains the specified key, replaces the key's mapping
     *  with the value specified.
     *
     *  将指定的值与此映射中的指定键相关联。
     *  如果映射已经包含指定的键，则用指定的值替换该键的映射。
     */
    void put(K key, V value);

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * 返回指定键映射到的值，如果此映射不包含该键的映射，则返回null。
     */
    V get(K key);

    /** Returns whether this map contains a mapping for the specified key.
     *
     * 返回此映射是否包含指定键的映射。
     */
    boolean containsKey(K key);

    /** Returns the number of key-value mappings in this map.
     *
     * 返回此映射中键值映射的数量。
     */
    int size();

    /** Removes every mapping from this map.
     *
     * 从此映射中删除所有映射。
     */
    void clear();

    /** Returns a Set view of the keys contained in this map. Not required for this lab.
     * If you don't implement this, throw an UnsupportedOperationException.
     *
     * 返回此映射中包含的键的Set视图。这个实验不需要实现此方法。
     * 如果你不实现此方法，请抛出UnsupportedOperationException异常。
     */
    Set<K> keySet();

    /** Removes the mapping for the specified key from this map if present,
     * or null if there is no such mapping.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException.
     *
     * 如果存在指定键的映射，则从此映射中删除该映射，如果不存在这样的映射则返回null。
     * 这个实验不需要实现此方法。如果你不实现此方法，请抛出UnsupportedOperationException异常。
     */
    V remove(K key);
}
