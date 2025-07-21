package hashmap;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * Tests by Brendan Hu, Spring 2015
 * Revised for 2016 by Josh Hug
 * Revised for 2021 by Neil Kulkarni
 * Revised for 2023 by Aram Kazorian and Noah Adhikari
 *
 * 测试由Brendan Hu编写，2015年春季
 * 2016年由Josh Hug修订
 * 2021年由Neil Kulkarni修订
 * 2023年由Aram Kazorian和Noah Adhikari修订
 */
public class TestMyHashMap {

    @DisplayName("generics")
    @Test
    public void testGenerics() {
        try {
            MyHashMap<String, String> a = new MyHashMap<>();
            MyHashMap<String, Integer> b = new MyHashMap<>();
            MyHashMap<Integer, String> c = new MyHashMap<>();
            MyHashMap<Boolean, Integer> d = new MyHashMap<>();
        } catch (Exception e) {
            fail();
        }
    }

    //assumes put/size/containsKey/get work
    // 假设put/size/containsKey/get方法正常工作
    @DisplayName("clear")
    @Test
    public void testClear() {
        sanityClearTest(new MyHashMap<>());
    }

    public static void sanityClearTest(MyHashMap<String, Integer> b) {
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, i);
            //make sure put is working via containsKey and get
            // 通过containsKey和get方法确保put方法正常工作
            assertThat(b.get("hi" + i)).isEqualTo(i);
            assertThat(b.containsKey("hi" + i)).isTrue();
        }
        assertThat(b.size()).isEqualTo(455);
        b.clear();
        assertThat(b.size()).isEqualTo(0);
        for (int i = 0; i < 455; i++) {
            assertThat(b.get("hi" + i)).isNull();
            assertThat(b.containsKey("hi" + i)).isFalse();
        }
    }

    // assumes put works
    // 假设put方法正常工作
    @DisplayName("containsKey")
    @Test
    public void testContainsKey() {
        containsKeyTest(new MyHashMap<>());
    }

    public static void containsKeyTest(MyHashMap<String, Integer> b) {
        assertThat(b.containsKey("waterYouDoingHere")).isFalse();
        b.put("waterYouDoingHere", 0);
        assertThat(b.containsKey("waterYouDoingHere")).isTrue();

        // Recall that even with a null value, containsKey should return true
        // 记住即使是null值，containsKey也应该返回true
        b.put("hashBrowns", null);
        assertThat(b.containsKey("hashBrowns")).isTrue();
    }

    // assumes put works
    // 假设put方法正常工作
    @DisplayName("get")
    @Test
    public void testGet() {
        sanityGetTest(new MyHashMap<>());
    }

    public static void sanityGetTest(MyHashMap<String, Integer> b) {
        assertThat(b.get("starChild")).isNull();
        b.put("starChild", 5);
        assertThat(b.get("starChild")).isEqualTo(5);
        b.put("KISS", 5);
        assertThat(b.get("KISS")).isEqualTo(5);
        assertThat(b.get("starChild")).isEqualTo(5);
    }

    // assumes put works
    // 假设put方法正常工作
    @DisplayName("size")
    @Test
    public void testSize() {
        sanitySizeTest(new MyHashMap<>());
    }

    public static void sanitySizeTest(MyHashMap<String, Integer> b) {
        assertThat(b.size()).isEqualTo(0);
        b.put("hi", 1);
        assertThat(b.size()).isEqualTo(1);
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertThat(b.size()).isEqualTo(456);
    }

    //assumes get/containsKey work
    // 假设get/containsKey方法正常工作
    @DisplayName("put")
    @Test
    public void testPut() {
        sanityPutTest(new MyHashMap<>());
    }

    public static void sanityPutTest(MyHashMap<String, Integer> b) {
        b.put("hi", 1);
        assertThat(b.containsKey("hi")).isTrue();
        assertThat(b.get("hi")).isEqualTo(1);
    }

    // Test for general functionality and that the properties of Maps hold.
    // 测试一般功能和Map属性是否成立
    @DisplayName("functionality")
    @Test
    public void testFunctionality() {
        functionalityTest(new MyHashMap<>(), new MyHashMap<>());
    }

    public static void functionalityTest(MyHashMap<String, String> dictionary,
                                         MyHashMap<String, Integer> studentIDs) {
        assertThat(dictionary.size()).isEqualTo(0);

        // can put objects in dictionary and get them
        // 可以向字典中放入对象并获取它们
        dictionary.put("hello", "world");
        assertThat(dictionary.containsKey("hello")).isTrue();
        assertThat(dictionary.get("hello")).isEqualTo("world");
        assertThat(dictionary.size()).isEqualTo(1);

        // putting with existing key updates the value
        // 使用现有键放入会更新值
        dictionary.put("hello", "kevin");
        assertThat(dictionary.size()).isEqualTo(1);
        assertThat(dictionary.get("hello")).isEqualTo("kevin");

        // putting key in multiple times does not affect behavior
        // 多次放入键不会影响行为
        studentIDs.put("sarah", 12345);
        assertThat(studentIDs.size()).isEqualTo(1);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        studentIDs.put("alan", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        studentIDs.put("alan", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        studentIDs.put("alan", 345);
        assertThat(studentIDs.size()).isEqualTo(2);
        assertThat(studentIDs.get("sarah")).isEqualTo(12345);
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        assertThat(studentIDs.containsKey("sarah")).isTrue();
        assertThat(studentIDs.containsKey("alan")).isTrue();

        // handle values being the same
        // 处理值相同的情况
        assertThat(studentIDs.get("alan")).isEqualTo(345);
        studentIDs.put("evil alan", 345);
        assertThat(studentIDs.get("evil alan")).isEqualTo(345);
        assertThat(studentIDs.get("alan")).isEqualTo(studentIDs.get("evil alan"));
    }

    /** Tests that the backing array is resized when the load factor is exceeded.
     *  In addition, times out if it takes too long (e.g. arithmetically instead of geometrically).
     *
     * 测试当负载因子超过时，底层数组是否被调整大小。
     * 此外，如果花费太长时间（例如，算术增长而不是几何增长），则会超时。
     */
    @DisplayName("resize")
    @Test
    public void testResize() {
        sanityResizeTest(new MyHashMap<>(), 16, 0.75);
        sanityResizeTest(new MyHashMap<>(32), 32, 0.75);
        sanityResizeTest(new MyHashMap<>(64, 0.5), 64, 0.5);
    }

    /** Times out after 10 seconds. Note that when debugging this test, you may run into timeout issues.
     *
     * 10秒后超时。注意在调试此测试时，你可能会遇到超时问题。
     */
    public static void sanityResizeTest(MyHashMap<String, Integer> m, int initialCapacity, double loadFactor) {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            int backingArrayCapacity = sizeOfBackingArray(m);
            assertThat(backingArrayCapacity).isEqualTo(initialCapacity);
            for (int i = 0; i < 100000; i++) {
                m.put("hi" + i, i);
                if (1.0 * i / backingArrayCapacity > loadFactor) {
                    assertThat(sizeOfBackingArray(m)).isGreaterThan(backingArrayCapacity);
                    backingArrayCapacity = sizeOfBackingArray(m);
                }
            }
        });
    }

    /** Returns the length of the backing array of the given map.
     *  Be sure that you only use one instance variable to hold the buckets,
     *  otherwise this will not work properly.

     *  Don't worry about knowing how this method works.
     *
     * 返回给定映射的底层数组的长度。
     * 确保你只使用一个实例变量来保存桶，
     * 否则这将无法正常工作。
     *
     * 不要担心理解这个方法是如何工作的。
     */
    private static <K, V> int sizeOfBackingArray(MyHashMap<K, V> m) {
        Class<?> clazz = m.getClass();
        if (clazz.getSuperclass().equals(MyHashMap.class)) {
            // anonymous bucketed extensions of MyHashMap
            clazz = clazz.getSuperclass();
        }
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType() == Collection[].class) {
                try {
                    Collection<MyHashMap<K, V>.Node>[] backingArray = (Collection[]) field.get(m);
                    return backingArray.length;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        throw new IllegalArgumentException("Could not find backing array");
    }


    @DisplayName("edge cases")
    @Test
    public void testEdgeCases() {
        edgeCasesTest(new MyHashMap<>());
    }

    /**
     * This test uses an unusual hash function and equals method to
     * capture some strange edge case behavior with collisions.

     * If you're stuck on this test, use the debugger to see what values are
     * expected from the reference map, which is Java's built-in HashMap.

     * If you're still stuck, walk through the expected behavior by hand.
     * Does your map behave the same way?
     * Note Bee's strange equals and hashCode implementations!
     *
     * 此测试使用不寻常的哈希函数和equals方法来
     * 捕获一些奇怪的边缘情况行为和冲突。
     *
     * 如果你在这个测试上卡住了，使用调试器查看
     * 参考映射（Java内置的HashMap）期望的值。
     *
     * 如果你仍然卡住，手动执行期望的行为。
     * 你的映射行为是否相同？
     * 注意Bee的奇怪的equals和hashCode实现！
     */
    static void edgeCasesTest(MyHashMap<Bee, Integer> map) {

        Map<Bee, Integer> ref = new HashMap<>();

        Bee b1 = new Bee(1);
        map.put(b1, 1);
        ref.put(b1, 1);
        assertThat(map.containsKey(b1)).isEqualTo(ref.containsKey(b1));

        Bee b2 = new Bee(2);
        assertThat(map.containsKey(b2)).isEqualTo(ref.containsKey(b2));

        map.put(b2, 2);
        ref.put(b2, 2);
        assertThat(map.get(b1)).isEqualTo(ref.get(b1));
        assertThat(map.get(b2)).isEqualTo(ref.get(b2));
        assertThat(map.containsKey(b1)).isEqualTo(ref.containsKey(b1));
        assertThat(map.containsKey(b2)).isEqualTo(ref.containsKey(b2));

        Bee b61 = new Bee(-61);
        assertThat(map.get(b61)).isEqualTo(ref.get(b61));
        assertThat(map.containsKey(b61)).isEqualTo(ref.containsKey(b61));
        assertThat(map.size()).isEqualTo(ref.size());

        map.put(b61, -61);
        ref.put(b61, -61);
        assertThat(map.get(b1)).isEqualTo(ref.get(b1));
        assertThat(map.get(b2)).isEqualTo(ref.get(b2));
        assertThat(map.get(b61)).isEqualTo(ref.get(b61));
        assertThat(map.size()).isEqualTo(ref.size());

        // trigger a resize
        // 触发调整大小
        for (int m = 3; m <= 61; m++) {
            Bee bm = new Bee(m * 61);
            assertThat(map.containsKey(bm)).isEqualTo(ref.containsKey(bm));
            assertThat(map.get(bm)).isEqualTo(ref.get(bm));
            map.put(bm, m * 61);
            ref.put(bm, m * 61);
            assertThat(map.containsKey(bm)).isEqualTo(ref.containsKey(bm));
            assertThat(map.get(bm)).isEqualTo(ref.get(bm));
            assertThat(map.get(b61)).isEqualTo(ref.get(b61));
            assertThat(map.size()).isEqualTo(ref.size());
        }

        for (int n = 0; n < 61; n++) {
            Bee bn = new Bee(n);
            map.put(bn, n);
            ref.put(bn, n);
            assertThat(map.containsKey(b1)).isEqualTo(ref.containsKey(b1));
            assertThat(map.containsKey(bn)).isEqualTo(ref.containsKey(bn));
            assertThat(map.get(b1)).isEqualTo(ref.get(b1));
            assertThat(map.get(bn)).isEqualTo(ref.get(bn));
            assertThat(map.size()).isEqualTo(ref.size());
        }
    }

    static class Bee {
        int b;

        Bee(int b) {
            this.b = b;
        }

        @Override
        public int hashCode() {
            return -61;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Bee other) {
                return Math.abs(b - other.b) < 61;
            }
            return false;
        }
    }
}
