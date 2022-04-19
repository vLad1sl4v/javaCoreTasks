package by.incubator.fileReader;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "./src/by/incubator/fileReader/input.txt";
    private static final String INCORRECT_FILE_PATH = "./input1.txt";
    private static final String EMPTY_FILE_PATH = "./src/by/incubator/fileReader/emptyFile.txt";

    private static void readFile(String path) throws EmptyFileException {
        File file = new File(path);

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(fileInputStream);
        ) {
            String fileLine = scanner.nextLine();
            System.out.printf("'%s' read from file '%s', %n", fileLine, path);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception '" + path + "'");
        } catch (IOException ex) {
            System.out.println("I/O exception for '" + path + "'");
            throw new EmptyFileException("I/O exception", ex, path);
        } catch (NoSuchElementException ex) {
            throw new EmptyFileException("Exception: empty file.", ex, path);
        }
        finally {
            System.out.println("finally method for '" + path + "'");
        }
    }

    public static void main(String[] args) {
        read(FILE_PATH);
        read(INCORRECT_FILE_PATH);
        read(EMPTY_FILE_PATH);
    }

    private static void read(String path) {
        System.out.println("Trying to read file:");
        try {
            readFile(FILE_PATH);
            readFile(path);
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage() + " You entered path: '" + e.getFilePath() + "'");
            e.printStackTrace();
            System.out.println("Cause of the exception: " + e.getCause());
        }
        System.out.println();
    }
}
