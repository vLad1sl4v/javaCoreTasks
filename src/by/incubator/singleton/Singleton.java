package by.incubator.singleton;

import java.util.Objects;

public class Singleton {
    private final int a;
    private final int b;
    private final int c;

    private Singleton(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Singleton instance() {
        return Holder.INSTANCE;
    }

    public String toString() {
        return a + ", " + b + ", " + c + ", " + Objects.hash(this);
    }

    private static class Holder {
        static final Singleton INSTANCE = new Singleton(1, 2, 3);
    }
}
