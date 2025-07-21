package hashmap;

import java.util.Collection;

/** This is a helper factory class that allows us to test different bucket types
 * without having to write a separate test for each one. You don't need to understand
 * how this works.
 *
 * Please don't modify this class unless you REALLY know what you're doing.
 *
 * @author Noah Adhikari, Spring 2023
 *
 * 这是一个辅助工厂类，允许我们测试不同的桶类型
 * 而无需为每种类型编写单独的测试。你不需要理解
 * 这是如何工作的。
 *
 * 除非你真的知道自己在做什么，否则请不要修改此类。
 *
 * @author Noah Adhikari, Spring 2023
 */
public class MyHashMapFactory {

    /** Returns a MyHashMap with the specified bucket type.
     * @param bucketType the type of bucket to use
     *
     * 返回一个具有指定桶类型的MyHashMap。
     * @param bucketType 要使用的桶类型
     */
    public static <K, V> MyHashMap<K, V> createBucketedMap(Class<? extends Collection> bucketType) {
        return new MyHashMap<>() {
            @Override
            protected Collection<Node> createBucket() {
                try {
                    return bucketType.getConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            // for the timing tests
            // 用于计时测试
            @Override
            public String toString() {
                return "MyHashMap with " + bucketType.getSimpleName() + " buckets";
            }
        };
    }
}
