import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

/** Performs a timing test on three different set implementations.
 *  对三种不同的集合实现执行计时测试。
 *  @author Josh Hug
 *  @author Brendan Hu
 */
public class InsertRandomSpeedTest {
    /**
     Requests user input and performs tests of three different set
     请求用户输入并对三种不同的集合实现执行测试。
     implementations. ARGS is unused.
     ARGS参数未使用。
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("This program inserts random "
                + "Strings of length L "
                + "into different types of maps "
                + "as <String, Integer> pairs.");
        System.out.print("Please enter desired length of each string: ");
        int L = waitForPositiveInt(input);

        String repeat;
        do {
            System.out.print("\nEnter # strings to insert into the maps: ");
            int N = waitForPositiveInt(input);
            timeRandomMap61B(new ULLMap<>(), N, L);
            timeRandomMap61B(new BSTMap<>(), N, L);
            timeRandomTreeMap(new TreeMap<>(), N, L);
            timeRandomHashMap(new HashMap<>(), N, L);

            System.out.print("Would you like to try more timed-tests? (y/n)");
            repeat = input.nextLine();
        } while (!repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("no"));
        input.close();
    }

    /** Returns time needed to put N random strings of length L into the
     *  返回将N个长度为L的随机字符串放入Map61B 61bMap所需的时间
     * Map61B 61bMap. */
    public static double insertRandom(Map61B<String, Integer> map61B, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s;
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            map61B.put(s, i);
        }
        return sw.elapsedTime();
    }

    /** Returns time needed to put N random strings of length L into the
     *  返回将N个长度为L的随机字符串放入给定TreeMap所需的时间
     * given TreeMap. */
    public static double insertRandom(TreeMap<String, Integer> treeMap, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s;
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            treeMap.put(s, i);
        }
        return sw.elapsedTime();
    }

    /** Returns time needed to put N random strings of length L into the
     *  返回将N个长度为L的随机字符串放入HashMap treeMap所需的时间
     * HashMap treeMap. */
    public static double insertRandom(HashMap<String, Integer> treeMap, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s;
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            treeMap.put(s, i);
        }
        return sw.elapsedTime();
    }

    /**
     Attempts to insert N random strings of length L into map,
     尝试将N个长度为L的随机字符串插入map，
     Prints time of the N insert calls, otherwise
     打印N次插入调用的时间，否则
     Prints a nice message about the error
     打印关于错误的友好消息
     */
    public static void timeRandomMap61B(Map61B<String, Integer> map, int N, int L) {
        try {
            double mapTime = insertRandom(map, N, L);
            System.out.printf(map.getClass() + ": %.2f sec\n", mapTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     Attempts to insert N random strings of length L into a TreeMap
     尝试将N个长度为L的随机字符串插入TreeMap
     Prints time of the N insert calls, otherwise
     打印N次插入调用的时间，否则
     Prints a nice message about the error
     打印关于错误的友好消息
     */
    public static void timeRandomTreeMap(TreeMap<String, Integer> treeMap, int N, int L) {
        try {
            double javaTime = insertRandom(treeMap, N, L);
            System.out.printf("Java's Built-in TreeMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     Attempts to insert N random strings of length L into a HashMap
     尝试将N个长度为L的随机字符串插入HashMap
     Prints time of the N insert calls, otherwise
     打印N次插入调用的时间，否则
     Prints a nice message about the error
     打印关于错误的友好消息
     */
    public static void timeRandomHashMap(HashMap<String, Integer> hashMap, int N, int L) {
        try {
            double javaTime = insertRandom(hashMap, N, L);
            System.out.printf("Java's Built-in HashMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     Waits for the user on other side of Scanner
     等待Scanner另一端的用户
     to enter a positive int,
     输入一个正整数，
     and outputs that int
     并输出该整数
     */
    public static int waitForPositiveInt(Scanner input) {
        int ret;
        do {
            while (!input.hasNextInt()) {
                errorBadIntegerInput();
                input.next();
            }
            ret = input.nextInt();
            input.nextLine(); //consume not taken by nextInt()
        } while (ret <= 0);
        return ret;
    }
    /* ------------------------------- Private methods ------------------------------- */
    /**
     To be called after catching a StackOverflowError
     在捕获StackOverflowError后调用
     Prints the error with corresponding N and L
     打印对应N和L的错误信息
     */
    private static void printInfoOnStackOverflow(int N, int L) {
        System.out.println("--Stack Overflow -- couldn't add " + N
                + " strings of length " + L + ".");
    }

    /** Prints a nice message for the user on bad input */
    /** 在输入错误时为用户打印友好消息 */
    private static void errorBadIntegerInput() {
        System.out.print("Please enter a positive integer: ");
    }

}
