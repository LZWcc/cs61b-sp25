/**
 * 练习题来源：华盛顿大学 Practice-It。
 * 原题链接：https://practiceit.cs.washington.edu/
 *
 * @author Erik Kizior
 */
public class IfElseMystery1 {
    public static void ifElseMystery1(int x, int y) {
        int z = 4;
        if (z <= x) {
            z = x + 1;
        } else {
            z = z + 9;
        }
        if (z <= y) {
            y++;
        }
        System.out.println(z + " " + y);
    }

    // TODO: 下面每个调用会输出什么？
    // TODO: For each call below, indicate what output is produced.
    public static void main(String[] args) {
        ifElseMystery1(3, 20);
        ifElseMystery1(4, 5);
        ifElseMystery1(5, 5);
        ifElseMystery1(6, 10);
    }
}

/* 在运行代码之前，请在下方写出你的答案。

TODO: 在此写出输出结果
13 21
5 6
5 6
7 11
Then, click the green play button to check your work. */