import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /**
     * 返回整数列表中所有元素的总和。
     * Returns the total sum in a list of integers
     */
    public static int sum(List<Integer> L) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        if (L.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < L.size(); i++) {
            sum += L.get(i);
        }
        // 设置元素 L.set(i, value)
        return sum;
    }

    /**
     * 返回给定列表中的所有偶数，组成一个新列表。
     * Returns a list containing the even numbers of the given list
     */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < L.size(); i++) {
            if (L.get(i) % 2 == 0) {
                ans.add(L.get(i));
            }
        }
        return ans;
    }

    /**
     * 返回两个给定列表的公共元素，组成一个新列表。
     * Returns a list containing the common item of the two given lists
     */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        List<Integer> common = new ArrayList<>();
        for (int i = 0; i < L1.size(); i++) {
            for (int j = 0; j < L2.size(); j++) {
                if (L1.get(i) == L2.get(j)) {
                    common.add(L1.get(i));
                }
            }
        }
        return common;
    }
    /**
     * 返回给定字符在字符串列表中出现的总次数。
     * Returns the number of occurrences of the given character in a list of strings.
     */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        int cnt = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
