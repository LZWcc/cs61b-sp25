package Lec02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> L = new LinkedList<>();
        L.add("a");
        L.add("b");
        L.add("c");
        System.out.println(L);
        System.out.println(L.get(0));
        String x = L.get(0);
        System.out.println(x);
    }
}
