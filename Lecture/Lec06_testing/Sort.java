package Lec06_testing;

public class Sort {
    public static void sort(String[] x) {
        sort(x, 0);
    }

    private static void sort(String[] x, int s) {
        if (s == x.length) {
            return ;
        }
        int smallest = findSmallest(x, s);
        swap(x, s, smallest);
        sort(x, s + 1);
    }

    public static int findSmallest(String[] x, int s) {
        int smallestIndex = s;
        /* a.compareTo(b) < 0  --> a < b
         * a.compareTo(b) > 0  --> a > b
         * a.compareTo(b) = 0  --> a = b
         */
        for (int i = s + 1; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
