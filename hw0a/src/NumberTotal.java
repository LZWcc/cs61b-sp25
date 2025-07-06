/**
 * 练习题来源：华盛顿大学 Practice-It。
 * 原题链接：https://practiceit.cs.washington.edu/
 *
 * @author Erik Kizior
 */

// TODO: 下列程序的输出是什么？
// TODO: What is the output of the following program?
public class NumberTotal {
    public static void main(String[] args) {
        int total = 25;
        for (int number = 1; number <= (total / 2); number++) {
            total = total - number;
            System.out.println(total + " " + number);
        }
    }
}

/* 在运行代码之前，请在下方写出你的答案。

TODO: 在此写出输出结果
number <= 12
24 1
22 2
19 3
15 4
10 5

Then, click the green play button to check your work. */