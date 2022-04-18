package by.incubator.comparators;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorsDemo {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("Vlad", 20);
        people[1] = new Person("Oleg", 20);
        people[2] = new Person("Alex", 18);
        people[3] = new Person("Artyom", 33);
        people[4] = new Person("Leonid", 25);

        showPeople(people);

        System.out.println("Comparing person 1 and person 2, result: " + people[0].compareTo(people[1]));
        System.out.println("Comparing person 2 and person 5, result: " + people[1].compare(people[1], people[4]));

        Arrays.sort(people, new Comparator<Person>() {
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
        });

        showPeople(people);

    }

    static void showPeople(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
}

