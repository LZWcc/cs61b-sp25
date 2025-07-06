/**
 * 练习题来源：华盛顿大学 Practice-It。
 * 原题链接：https://practiceit.cs.washington.edu/
 *
 * @author Erik Kizior
 */
public class JavaExercises {

    /**
     * 打印一个右对齐的星号（'*'）三角形，共5行。
     * 第一行1个星号，第二行2个星号，依此类推。
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on.
     */
    public static void starTriangle() {
        // TODO: 实现此函数
        // TODO: Fill in this function
        for (int i = 5; i >= 1; i--) {
            for(int j = i; j > 1; j--) System.out.print(" ");
            for(int k = 0; k <= 5 - i; k++) System.out.print("*");
            System.out.println();
        }
    }

    /**
     * 打印给定字符串的每个字符，后跟其反向索引。
     * 例如：printIndexed("hello") -> h4e3l2l1o0
     * Prints each character of a given string followed by its reverse index.
     * Example: printIndexed("hello") -> h4e3l2l1o0
     */
    public static void printIndexed(String s) {
        // TODO: 实现此函数
        // TODO: Fill in this function
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            System.out.print(s.length() - i - 1);
        }
    }

    /**
     * 返回一个新字符串，其中给定字符串的每个字符都重复两次。
     * 例如：stutter("hello") -> "hheelllloo"
     * Returns a new string where each character of the given string is repeated twice.
     * Example: stutter("hello") -> "hheelllloo"
     */
    public static String stutter(String s) {
        // TODO: 实现此函数
        // TODO: Fill in this function
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(i);
            result += s.charAt(i);
        }
        return result;
    }

    /**
     * 判断平面直角坐标 (x, y) 所在的象限。
     * 返回值：
     *   1 表示第一象限 (x > 0, y > 0)，
     *   2 表示第二象限 (x < 0, y > 0)，
     *   3 表示第三象限 (x < 0, y < 0)，
     *   4 表示第四象限 (x > 0, y < 0)，
     *   0 表示点在坐标轴上。
     * Determines the quadrant of a Cartesian coordinate (x, y).
     * Returns:
     *   1 for the first quadrant (x > 0, y > 0),
     *   2 for the second quadrant (x < 0, y > 0),
     *   3 for the third quadrant (x < 0, y < 0),
     *   4 for the fourth quadrant (x > 0, y < 0),
     *   0 if the point lies on an axis.
     */
    public static int quadrant(int x, int y) {
        // TODO: 实现此函数
        // TODO: Fill in this function
        if (x > 0 && y > 0) return 1;
        else if (x < 0 && y > 0) return 2;
        else if (x < 0 && y < 0) return 3;
        else if (x > 0 && y < 0) return 4;
        return 0;
    }

    public static void main(String[] args) {
        starTriangle();
        printIndexed("hello");
        System.out.println(stutter("hello"));
        System.out.println(quadrant(3, 4));  // Output: 1
        System.out.println(quadrant(-3, 4)); // Output: 2
        System.out.println(quadrant(-3, -4));// Output: 3
        System.out.println(quadrant(3, -4)); // Output: 4
        System.out.println(quadrant(0, 5));  // Output: 0
    }
}
