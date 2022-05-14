package by.incubator.codeAnalyzer;

import java.io.Serializable;

public class Test implements Serializable, Comparable{
    public int age;
    public String name;

    @Deprecated
    private double length;

    public Test(){

    }

    @Deprecated
    public Test(int age, int name) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
