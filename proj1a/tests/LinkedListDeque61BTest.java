import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests.
 *  执行一些基本的链表测试。
 */
public class LinkedListDeque61BTest {

     @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly.
      *  在此测试中，我们有三个不同的断言语句来验证 addFirst 是否正常工作。
      */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         // 调用后我们期望: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         // 调用后我们期望: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         // 调用后我们期望: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
            注意：前两个 assertThat 语句其实并不是必须的。例如，很难想象你的代码中会有一个 bug，
            会导致 ["front"] 和 ["front", "middle"] 失败，但 ["front", "middle", "back"] 却不会失败。
          */
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it.
      *  在此测试中，我们只使用了一个 assertThat 语句。在我看来，这个测试和 addFirstTestBasic 一样好。
      *  换句话说，添加额外 assertThat 语句的繁琐工作并不值得。
      */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         // 调用后我们期望: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         // 调用后我们期望: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         // 调用后我们期望: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls.
      *  此测试交替执行 addFirst 和 addLast 调用。
      */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose.
            我决定在每个调用后添加注释以显示状态，以方便阅读此测试的人。
            有些程序员可能会认为这过于冗长。
          */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

    // Below, you'll write your own tests for LinkedListDeque61B.
    /* inOrder(): 强制断言集合的元素顺序也要一致 */
    @Test
    /* 检查addFirst在空双端队列上的操作是否正确。 */
    public void add_first_from_empty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst("My name is LZWcc.");
        assertThat(lld1.toList()).containsExactly("My name is LZWcc.").inOrder();
    }

    @Test
    /* 检查addLast在空双端队列上的操作是否正常。*/
    public void add_last_from_empty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(67);
        assertThat(lld1.toList()).containsExactly(67).inOrder();
    }

    @Test
    /* 检查addFirst在非空双端队列上的工作是否正常。 */
    public void add_first_nonempty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst("zyq");
        lld1.addFirst("yqq");
        assertThat(lld1.toList()).containsExactly("yqq", "zyq").inOrder();
    }

    @Test
    /* 检查 addLast 在非空双端队列上的操作。*/
    public void add_last_nonempty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addLast("zyq");
        lld1.addLast("yqq");
        assertThat(lld1.toList()).containsExactly("zyq", "yqq").inOrder();
    }

    @Test
    /* 检查size是否正常工作 */
    public void size() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.size()).isEqualTo(0);
        lld1.addLast(20);
        lld1.addLast(30);
        lld1.addLast(40);
        assertThat(lld1.size()).isEqualTo(3);
    }

    @Test
    /* 检查isEmpty在空双端队列上是否有效。*/
    public void is_empty_true() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    /* 检查isEmpty在非空双端队列上的工作情况。*/
    public void is_empty_false() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(30);
        assertThat(lld1.isEmpty()).isFalse();
    }

    @Test
    /* 检查get在有效索引上是否有效。*/
    public void get_valid() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.get(0)).isEqualTo(10);
        assertThat(lld1.get(2)).isEqualTo(30);
    }

    @Test
    /* 检查get是否适用于大型越界索引。*/
    public void get_oob_large() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.get(0)).isEqualTo(10);
        assertThat(lld1.get(2)).isEqualTo(30);
        assertThat(lld1.get(100010)).isNull();
    }

    @Test
    /* 检查get在负索引上是否有效 */
    public void get_oob_neg() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.get(0)).isEqualTo(10);
        assertThat(lld1.get(2)).isEqualTo(30);
        assertThat(lld1.get(-101021)).isNull();
    }

    @Test
    /* 检查getRecursive在有效索引上是否有效。*/
    public void get_recursive_valid() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.getRecursive(0)).isEqualTo(10);
        assertThat(lld1.getRecursive(2)).isEqualTo(30);
    }

    @Test
    /* 检查getRecursive是否适用于大型越界索引。*/
    public void get_recursive_oob_large() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.getRecursive(0)).isEqualTo(10);
        assertThat(lld1.getRecursive(2)).isEqualTo(30);
        assertThat(lld1.getRecursive(100010)).isNull();
    }

    @Test
    /* 检查getRecursive在负索引上是否有效 */
    public void get_recursive_oob_neg() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        assertThat(lld1.getRecursive(0)).isEqualTo(10);
        assertThat(lld1.getRecursive(2)).isEqualTo(30);
        assertThat(lld1.getRecursive(-101021)).isNull();
    }

    @Test
    /* 检查removeFirst是否正常工作。 */
    public void remove_first() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.addLast(30);
        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly(20, 30).inOrder();
    }

    @Test
    public void size_after_remove_from_empty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(10);
        lld1.addLast(20);
        lld1.removeFirst();
        lld1.removeLast();
        assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    public void to_list_empty() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        assertThat(lld1.toList()).isEmpty();
    }

    @Test
    /* 向双端队列添加一些元素并全部移除，然后检查addFirst是否仍能正常工作 */
    public void add_first_after_remove_to_empty() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        lld1.addFirst("zyq");
        lld1.addFirst("yqq");
        lld1.removeLast();
        lld1.removeFirst();
        assertThat(lld1.isEmpty()).isTrue();
        lld1.addFirst("zyq");
        lld1.addFirst("yqq");
        assertThat(lld1.toList()).containsExactly("yqq", "zyq").inOrder();
        assertThat(lld1.size()).isEqualTo(2);
    }
}