import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class MapExercises {
    /**
     * 返回一个映射，将每个小写字母映射到对应的数字，'a'为1，'b'为2，...，'z'为26。
     * Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)('a' + i), i + 1);
        }
        return map;
    }

    /**
     * 返回一个映射，将输入列表中的每个整数映射到其平方。
     * 例如，输入列表为[1, 3, 6, 7]，返回的映射为1->1, 3->9, 6->36, 7->49。
     * Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), nums.get(i) * nums.get(i));
        }
        return map;
    }

    /**
     * 返回一个映射，统计单词列表中每个单词出现的次数。
     * Returns a map of the counts of all words that appear in a list of words.
     */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            /* cnt.containsKey(word) 判断是否存在某个键 */
            if (cnt.containsKey(word)) {
                // 如果存在, cnt++
                /* cnt.put(word, value) 插入或更新键值对 */
                /* cnt.get(word) 获取键对应的值 */
                cnt.put(word, cnt.get(word) + 1);
            }
            else {
                cnt.put(word, 1);
            }
        }
        return cnt;
    }
}
