import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    /**
     * 返回一个数组 [1, 2, 3, 4, 5, 6]
     * Returns an array [1, 2, 3, 4, 5, 6]
     */
    public static int[] makeDice() {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    /**
     * 根据顾客返回订单。
     * 如果顾客是 Ergun，返回 ["beyti", "pizza", "hamburger", "tea"]。
     * 如果顾客是 Erik，返回 ["sushi", "pasta", "avocado", "coffee"]。
     * 其他情况返回长度为3的空字符串数组。
     * Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3.
     */
    public static String[] takeOrder(String customer) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        if (customer.equals("Ergun")) {
            return new String[]{"beyti", "pizza", "hamburger", "tea"};
        } else if (customer.equals("Erik"))
            return new String[]{"sushi", "pasta", "avocado", "coffee"};
        return new String[3];
    }

    /**
     * 返回给定数组最大元素和最小元素的正差值。
     * 假设数组非空。
     * Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty.
     */
    public static int findMinMax(int[] array) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        int min = 100000;
        int max = -100000;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        return max - min;
    }

    /**
      * 使用递归计算以输入数字 n 开始的海尔斯通序列，结果以整数列表形式返回。
      * 海尔斯通序列描述如下：
      *    - 选择一个正整数 n 作为起始
      *        - 如果 n 是偶数，将 n 除以 2
      *        - 如果 n 是奇数，将 n 乘以 3 然后加 1
      *    - 重复此过程直到 n 为 1
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
      *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        // TODO: 实现此函数。
        // TODO: Fill in this function.
        list.add(x);
        if (x == 1) {
            return list;
        }
        if (x % 2 == 0) {
            return hailstoneHelper(x / 2, list);
        } else {
            return hailstoneHelper(x * 3 + 1, list);
        }
    }

}
