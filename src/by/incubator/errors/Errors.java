package by.incubator.errors;

import java.util.ArrayList;

public class Errors {
    public static void main(String[] args) {
//        recursion1();
//        recursion2(20);
//        a();
//        long[] longs = new long[Integer.MAX_VALUE];

        ArrayList<A> arrayList = new ArrayList<>();
        int counter = 0;
        while (true) {
            counter++;
            System.out.println(counter);
            arrayList.add(new A());
        }
    }

    static void recursion1() {
        recursion1();
    }

    static int recursion2(int a) {
        a++;
        return recursion2(a);
    }

    static void a() {
        b();
    }

    static void b() {
        a();
    }
}

class A {
    double a;
    long b;
    Object obj;
    String str;
    long[] longs = new long[200];
}