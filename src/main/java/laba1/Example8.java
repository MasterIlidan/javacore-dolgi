package laba1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayOfWeek, day, month;

        System.out.print("Enter day of week: ");
        dayOfWeek = scanner.nextLine();
        System.out.print("Enter month: ");
        month = scanner.nextLine();
        System.out.print("Enter day: ");
        day = scanner.nextLine();

        System.out.printf("Day of week: %s\nDay: %s\nMonth: %s", dayOfWeek, day, month);
    }
}
