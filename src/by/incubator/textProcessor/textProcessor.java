package by.incubator.textProcessor;

import java.util.Scanner;

public class textProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        workingWithText();

        System.out.print("Please, input your string to reverse: ");
        String strRev = scanner.nextLine();
        char[] charStr = reverseString(strRev);

        for (char aChar: charStr) {
            System.out.print(aChar);
        }
        System.out.println();

        System.out.print("Please, input your string to delete spaces: ");
        String strDeleteSpaces = scanner.nextLine();
        char[] chars = deleteSpaces(strDeleteSpaces);

        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();

        System.out.println("Enter a string to return only upperCase letters: ");
        String stringUpperAndLower = scanner.nextLine();
        StringBuilder stringOnlyUpper = getUpperCase(stringUpperAndLower);
        System.out.println(stringOnlyUpper);

        System.out.println("Enter a string to return only even upperCases letters: ");
        String anyString = scanner.nextLine();
        StringBuilder stringEvenUpper = getEvenUpperCase(anyString);
        System.out.println(stringEvenUpper);

        int arraySize;

        do {
            System.out.println("Let's process a string array. Please, input the array size [1, ...]: ");
            arraySize = Integer.parseInt(scanner.nextLine());
        } while (arraySize <= 0);

        String[] strArr = new String[arraySize]; //add do while

        System.out.println("Now enter all array elements: ");

        for (int i = 0; i < arraySize; i++) {
            strArr[i] = scanner.nextLine();
        }

        System.out.println("Processed array: ");
        String[] processedArr = replaceNulls(strArr, arraySize);
        for (String aString : processedArr) {
            System.out.println(aString);
        }
        System.out.println();

        comparingStrings();
    }

    static void workingWithText() {
        String str = "Hello, user! How are you?";
        StringBuilder stringBuilder = new StringBuilder(str);

        System.out.println(stringBuilder.append("Fine!"));
        stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.insert(6, "dear"));
        stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.deleteCharAt(str.indexOf('!')));
        stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.replace(7, 11, "programmer"));
    }

    static char[] reverseString(String str) {
        int strSize;
        char memory;
        char[] charStr;

        strSize = str.length();
        charStr = str.toCharArray();

        for (int i = 0; i < strSize / 2; i++){
            memory = charStr[i];
            charStr[i] = charStr[strSize - i - 1];
            charStr[strSize - i - 1] = memory;
        }

        return charStr;
    }

    static char[] deleteSpaces(String str) {
        int strSize;
        int spaceCount = 0;
        char[] charStr;
        int charsUntilDot = 0;
        int processedCharsIndex = 0;

        strSize = str.length();
        charStr = str.toCharArray();

        for (int i = 0; i < strSize; i++) {
            if (charStr[i] == ' ') {
                spaceCount++;
            }

            charsUntilDot++;

            if (charStr[i] == '.') {
                break;
            }
        }

        char[] processedChars = new char[charsUntilDot - spaceCount];

        for (int j = 0; j < charsUntilDot; j++) {
            if (charStr[j] != ' ') {
                processedChars[processedCharsIndex] = charStr[j];
                processedCharsIndex++;
            }
        }

        return processedChars;
    }

    static StringBuilder getUpperCase(String string) {
        StringBuilder upperCaseStr = new StringBuilder();
        char[] charStr;

        charStr = string.toCharArray();

        for (char c : charStr) {
            if (Character.isUpperCase(c)) {
                upperCaseStr.append(c);
            }
        }

        return upperCaseStr;
    }

    static StringBuilder getEvenUpperCase(String string) {
        StringBuilder evenUpperCaseStr = new StringBuilder();
        char[] charStr;

        charStr = string.toCharArray();

        for (int i = 1; i < charStr.length; i += 2) {
            evenUpperCaseStr.append(Character.toUpperCase(charStr[i]));
        }

        return evenUpperCaseStr;
    }

    static String[] replaceNulls(String[] string, int size) {
        String[] processedArr = new String[size];

        for (int i = 0; i < size; i++) {
           processedArr[i] = (string[i].equals("") ? "String is empty" : string[i]);
        }

        return processedArr;
    }

    static void comparingStrings() {
        String str1 = "Java";
        String str2 = "JAVA";
        String str3 = "C#";
        String str4 = "Java";

        System.out.println("Comparing strings 1 by 1: ");
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println(str2.equals(str3));
        System.out.println(str2.equals(str4));
        System.out.println(str3.equals(str4));

        System.out.println("Comparing str1 and str2 with ignoring case: ");
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println("Comparing str1 and str4 w ==: ");
        System.out.println(str1 == str4);

        str1 = "JavaJava";
        System.out.println("Checking if str4 is substring of str1: ");
        System.out.println(str1.substring(4) == str4);

        System.out.println("Comparing str1 w null");
        System.out.println(str1 == null);

        str1 = null;
        System.out.println("Checking is str1 null now: ");
        System.out.println(str1 == null);
    }
}

