package by.incubator.school;

public class Student {
    static private int studentNum;
    private final String lastName;
    private final String firstName;
    private double gradeAvg;
    static final int schoolNum = 41;

    Student(String lastName, String firstName, double gradeAvg) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gradeAvg = gradeAvg;

        studentNum++;
        System.out.println("Default constructor execution: " + studentNum);
    }

    public static void displayStudentNum() {
        System.out.println("Number of students: " + studentNum);
    }

    public String toString() {
        return lastName + " " + firstName + " " + gradeAvg;
    }

    public double getGradeAvg() {
        return gradeAvg;
    }
}
