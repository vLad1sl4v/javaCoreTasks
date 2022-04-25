package by.incubator.fromJoseph;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FromJoseph {
    public static void main(String[] args) {
        int warriorsNum = getWarriors();
        List<String> warriors = initArrayList(warriorsNum);
        warriors = killEveryNd(warriors, 3);
        System.out.println(warriors.get(0));

        warriorsNum = getWarriors();
        List<String> warriorsLinked = initLinkedList(warriorsNum);
        warriorsLinked = killEveryNd(warriorsLinked, 3);
        System.out.println(warriorsLinked.get(0));
    }

    private static List<String> initLinkedList(int warriorsNum) {
        LinkedList<String> warriors = new LinkedList<>();

        for (int i = 0; i < warriorsNum; i++) {
            int warriorNum = i + 1;
            warriors.add("warrior " + warriorNum);
        }

        return warriors;
    }

    private static List<String> killEveryNd(List<String> warriors, int n) {
        int nextToKill = n - 1;
        while (warriors.size() != 1) {
                warriors.remove(nextToKill);
                nextToKill = getNextToKill(nextToKill, warriors.size(), n - 1);
            }
        return warriors;
    }

    private static int getNextToKill(int previous, int size, int difference) {
        int next = 0;

        next = previous + difference;

        if (next >= size) {
            do {
                next = next - size;
            } while (next >= size);
        }

        return next;
    }

    private static int getWarriors() {
        int num = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many warriors are there?");

        num = Integer.parseInt(scanner.nextLine());

        return num;
    }

    private static ArrayList<String> initArrayList(int num) {
        ArrayList<String> warriors = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            int warriorNum = i + 1;
            warriors.add("warrior " + warriorNum);
        }

        return warriors;
    }
}
