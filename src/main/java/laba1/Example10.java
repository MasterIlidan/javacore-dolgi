package laba1;

import java.util.Calendar;
import java.util.Scanner;

public class Example10 {
    /*Напишите программу, в которой по году рождения определяется возраст
    пользователя.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birth year: ");
        int birthYear = scanner.nextInt();

        int todayYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.println("Your age probably is " + (todayYear - birthYear));

    }
}
