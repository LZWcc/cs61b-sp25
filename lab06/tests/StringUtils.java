import java.util.Random;
import java.util.regex.Pattern;

/** Utility function for Strings.
 *  字符串的实用工具函数。
 *  @author Josh Hug
 */
public class StringUtils {
    /** To get the style checker to be quiet. */
    /** 让代码风格检查器保持安静。 */
    private static final int ALPHABET_SIZE = 26;

    /** Random number generator for this class. */
    /** 此类的随机数生成器。 */
    private static Random r = new Random();

    /** Sets random seed to L so that results of randomString are predictable.*/
    /** 将随机种子设置为L，使randomString的结果可预测。 */
    public static void setSeed(long l) {
        r = new Random(l);
    }

    /** Returns the next random string of length LENGTH. */
    /** 返回长度为LENGTH的下一个随机字符串。 */
    public static String randomString(int length) {
        char[] someChars = new char[length];
        for (int i = 0; i < length; i++) {
            someChars[i] = (char) (r.nextInt(ALPHABET_SIZE) + 'a');
        }
        return new String(someChars);
    }

    /** Returns true if string S consists of characters between
      * 如果字符串S仅由'a'到'z'之间的字符组成，��返回true。
      * 'a' and 'z' only. No spaces, numbers, upper-case, or any other
      * 不允许空格、数字、大写字母或任何其他字符。
      * characters are allowed.
      */
    public static boolean isLowerCase(String s) {
        return Pattern.matches("[a-z]*", s);
    }

    /** Returns the string that comes right after S in alphabetical order.
      * 返回在字母顺序中紧接在S之后的字符串。
      * For example, if s is 'potato', this method will return 'potatp'. If
      * 例如，如果s是'potato'，此方法将返回'potatp'。如果
      * the last character is a z, then we add to the next position, and so
      * 最后一个字符是z，则我们添加到下一个位置，依此类推。
      * on.
      */
    public static String nextString(String s) {
        /* Handle all zs as a special case to keep helper method simple. */
        /* 将所有z的情况作为特殊情况处理，以保持辅助方法简单。 */
        if (isAllzs(s)) {
            return allAs(s.length() + 1);
        }
        char[] charVersion = s.toCharArray();
        incrementCharArray(charVersion, charVersion.length - 1);
        return new String(charVersion);
    }

    /** Helper function for nextString. Increments the Pth position of X
      * nextString的辅助函数。将X的第P个位置增加1，
      * by one, wrapping around to 'a' if p == 'z'. If wraparound occurs,
      * 如果p == 'z'则环绕到'a'。如果发生环绕，
      * then we need to carry the one, and we increment position P - 1.
      * 则我们需要进位，增加位置P - 1。
      *
      * Will fail for a character array containing only zs.
      * 对于仅包含z的字符数组会失败。
      */
    private static void incrementCharArray(char [] x, int p) {
        if (x[p] != 'z') {
            x[p] += 1;
        } else {
            x[p] = 'a';
            incrementCharArray(x, p - 1);
        }
    }

    /** Returns a string of all 'a' of length LEN. */
    /** 返回长度为LEN的全为'a'的字符串。 */
    private static String allAs(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    /** Returns true if S is all 'z'. False for empty strings */
    /** 如果S全为'z'则返回true。空字符串返回false */
    public static boolean isAllzs(String s) {
        return Pattern.matches("[z]+", s);
    }

}
