package Lec03;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        /* 不能使用this == null -> NullPointer error */
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        /* 声明一个 IntList 类型的变量 p，并让它指向当前对象 */
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            return first;
        }

        return this.rest.get(i - 1);
    }


    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);

        /* 30 -> 25 -> 20 */
        IntList L2 = new IntList(20, null);
        L2 = new IntList(25, L2);
        L2 = new IntList(30, L2);
        System.out.println(L.get(2));
    }
}

