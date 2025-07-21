package hashmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static hashmap.MyHashMapFactory.createBucketedMap;

/**
 * Tests by Brendan Hu, Spring 2015
 * Revised for 2016 by Josh Hug
 * Revised for 2021 by Neil Kulkarni
 * Revised for 2023 by Noah Adhikari
 *
 * 测试由Brendan Hu编写，2015年春季
 * 2016年由Josh Hug修订
 * 2021年由Neil Kulkarni修订
 * 2023年由Noah Adhikari修订
 */

/**
 * This class tests MyHashMap with different bucket types
 * imported from java.util. You should pass the tests in
 * TestMyHashMap before attempting these tests.
 *
 * 此类使用从java.util导入的不同桶类型测试MyHashMap。
 * 在尝试这些测试之前，你应该通过TestMyHashMap中的测试。
 */
public class TestMyHashMapBuckets {

    @DisplayName("generics")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void sanityGenericsTest(Class<? extends Collection<?>> bucketType) {
        MyHashMap<String, Integer> ignored1 = createBucketedMap(bucketType);
        MyHashMap<String, Integer> ignored2 = createBucketedMap(bucketType);
        MyHashMap<Integer, String> ignored3 = createBucketedMap(bucketType);
        MyHashMap<Boolean, Integer> ignored4 = createBucketedMap(bucketType);
    }

    @DisplayName("clear")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void sanityClearTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.sanityClearTest(createBucketedMap(bucketType));
    }

    @DisplayName("containsKey")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void containsKeyTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.containsKeyTest(createBucketedMap(bucketType));
    }

    @DisplayName("get")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void sanityGetTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.sanityGetTest(createBucketedMap(bucketType));
    }

    @DisplayName("size")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void sanitySizeTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.sanitySizeTest(createBucketedMap(bucketType));
    }

    @DisplayName("put")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void sanityPutTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.sanityPutTest(createBucketedMap(bucketType));
    }

    @DisplayName("functionality")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void functionalityTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.functionalityTest(createBucketedMap(bucketType),
                                        createBucketedMap(bucketType));
    }

    @DisplayName("resize")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void resizeTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.sanityResizeTest(createBucketedMap(bucketType), 16, 0.75);
    }

    @DisplayName("edge cases")
    @ParameterizedTest
    @MethodSource("bucketArguments")
    public void edgeCasesTest(Class<? extends Collection<?>> bucketType) {
        TestMyHashMap.edgeCasesTest(createBucketedMap(bucketType));
    }

    private static Stream<Arguments> bucketArguments() {
        return Stream.of(
                Arguments.of(Named.of("LinkedList", LinkedList.class)),
                Arguments.of(Named.of("ArrayList", ArrayList.class)),
                Arguments.of(Named.of("HashSet", HashSet.class)),
                Arguments.of(Named.of("Stack", Stack.class)),
                Arguments.of(Named.of("ArrayDeque", ArrayDeque.class))
        );
    }
}
