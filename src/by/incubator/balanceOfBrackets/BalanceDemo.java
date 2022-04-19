package by.incubator.balanceOfBrackets;

import java.util.*;

public class BalanceDemo {
    public static void main(String[] args) {
        String input = getString();
        boolean correctBrackets = checkBrackets(input);

        System.out.println(correctBrackets ? "correct" : "incorrect");
    }

    private static boolean checkBrackets(String input) {
        List<Character> charList = getCharList(input);
        List<Character> openBracketsList = Arrays.asList('(', '{', '[', '<');
        List<Character> closeBracketsList = Arrays.asList(')', '}', ']', '>');

        int[] unpairedBrackets = new int[4];

        ListIterator<Character> listIterator = charList.listIterator();

        Deque<Character> unpairedCh = new ArrayDeque<>();
        while (listIterator.hasNext()) {
            char ch = listIterator.next();

            if (openBracketsList.contains(ch)) {
                unpairedBrackets[openBracketsList.indexOf(ch)]++;
                unpairedCh.addLast(ch);
            } else if (closeBracketsList.contains(ch)) {
                if (closeBracketsList.indexOf(ch) == openBracketsList.indexOf(unpairedCh.peekLast())) {
                    unpairedBrackets[closeBracketsList.indexOf(ch)]--;
                    unpairedCh.pollLast();
                } else {
                    return false;
                }
            }
        }

        return getSum(unpairedBrackets) == 0;
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Please, input a string: ");
        input = scanner.nextLine();

        return input;
    }

    private static List<Character> getCharList(String str) {
        List<Character> characters = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            characters.add(ch);
        }

        return characters;
    }

    private static int getSum(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}

