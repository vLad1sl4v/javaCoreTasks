package by.incubator.school;

import java.util.Scanner;

public class SchoolDemo {
    public static void main(String[] args) {
        final int SIZE;
        Scanner scanner = new Scanner(System.in);
        double gradeAvg;
        String lastName;
        String firstName;

        System.out.println("Please, input the length of an array with students: ");
        SIZE = Integer.parseInt(scanner.nextLine());
        Student[] students = new Student[SIZE];

        System.out.println("Input last name, first name, average grade for every student: ");

        for (int i = 0; i < SIZE; i++) {
            System.out.println("Enter last name:");
            lastName = scanner.nextLine();

            System.out.println("Enter first name:");
            firstName = scanner.nextLine();

            gradeAvg = checkGradeAvg();

            students[i] = new Student(lastName, firstName, gradeAvg);
        }


        double avgAmongStudents = students[0].getGradeAvg() / SIZE;
        for (int i = 1; i < SIZE; i++) {
            avgAmongStudents += students[i].getGradeAvg() / SIZE;
        }

        System.out.printf("Average grade among students: %.2f\n" , avgAmongStudents);

        for (Student aStudent : students) {
            if (aStudent.getGradeAvg() < avgAmongStudents) {
                System.out.println(aStudent);
            }
        }
    }

    static double checkGradeAvg() {
        double gradeAvg = 0.0d;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter grade avg[1..10]:");
            gradeAvg = Double.parseDouble(scanner.nextLine());
        } while (gradeAvg < 1.0 || gradeAvg > 10.0);

        return gradeAvg;
    }
}
