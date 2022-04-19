package by.incubator.comparators;

import java.util.Comparator;

public class Person implements Comparator<Person>, Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Person o1, Person o2) {
        int result = 0;

        if (o1.age > o2.age) {
            result = 1;
        } else if (o1.age < o2.age) {
            result = -1;
        } else {
            result = o1.name.compareTo(o2.name);
        }

        return result;
    }


    @Override
    public int compareTo(Person o) {
        int result = 0;

        if (this.age > o.age) {
            result = 1;
        } else if (this.age < o.age) {
            result = -1;
        } else {
            result = this.name.compareTo(o.name);
        }

        return result;
    }

    public String toString() {
        return name + ", " + age;
    }
}