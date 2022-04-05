package by.incubator.daysOfWeek;

import java.util.Scanner;

public class daysOfWeekDemo {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        String aWeekend = "is a weekend";
        String notAWeekend = "is not a weekend";

        System.out.println("Please, input the number of the day: ");

        choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= Weekday.values().length) {
            Weekday weekday = Weekday.values()[choice - 1];
            System.out.println(weekday + " (" + weekday.getAbbreviation() + ") " + (weekday.isWeekend() ?
                    aWeekend : notAWeekend));
        } else {
            System.out.println(choice);
        }
    }
}

enum Weekday {
    MONDAY(false, "MON"),
    TUESDAY(false, "TUE"),
    WEDNESDAY(false, "WED"),
    THURSDAY(false, "THU"),
    FRIDAY(false, "FRI"),
    SATURDAY(true, "SAT"),
    SUNDAY(true, "SUN");

    private final boolean weekend;
    private final String abbreviation;

    Weekday(boolean weekend, String abbreviation) {
        this.weekend = weekend;
        this.abbreviation = abbreviation;
    }


    public String getAbbreviation() {
        return this.abbreviation;
    }

    public boolean isWeekend() {
        return this.weekend;
    }
}
