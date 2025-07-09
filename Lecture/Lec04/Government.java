package Lec04;

/** A rather contrived exercise to test your understanding of when
 nested classes may be made static. This is NOT an example of good
 class design, even after you fix the bug.

 一个相当做作的练习，用来测试你对嵌套类何时可以声明为 static 的理解。即使你修复了 bug，这也不是一个好的类设计示例。

 The challenge with this file is to delete the keyword static the
 minimum number of times so that the code compiles.

 本文件的挑战是：删除 static 关键字的次数要尽量少，以使代码能够编译通过。

 Guess before TRYING to compile, otherwise the compiler will spoil
 the problem.*/

 // 在尝试编译之前先猜一猜，否则编译器会剧透这个问题。
public class Government {
    private int treasury = 5;

    private void spend() {
        treasury -= 1;
    }

    private void tax() {
        treasury += 1;
    }

    public void report() {
        System.out.println(treasury);
    }

    public static Government greaterTreasury(Government a, Government b) {
        if (a.treasury > b.treasury) {
            return a;
        }
        return b;
    }

    public static class Peasant {
        public void doStuff() {
            System.out.println("hello");
        }
    }

    public class King {
        public void doStuff() {
            spend();
        }
    }

    public class Mayor {
        public void doStuff() {
            tax();
        }
    }

    public class Accountant {
        public void doStuff() {
            report();
        }
    }

    public class Thief {
        public void doStuff() {
            treasury = 0;
        }
    }

    public static class Explorer {
        public void doStuff(Government a, Government b) {
            Government favorite = Government.greaterTreasury(a, b);
            System.out.println("The best government has treasury " + favorite.treasury);
        }
    }
}
