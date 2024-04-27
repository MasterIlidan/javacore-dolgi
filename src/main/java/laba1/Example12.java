package laba1;

import java.util.Calendar;
import java.util.Scanner;

public class Example12 {
    //    Напишите программу, в которой по возрасту определяется год рождения.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Your birth date probably is: " + (currentYear - age));
    }
}
