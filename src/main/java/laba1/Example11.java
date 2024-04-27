package laba1;

import java.util.Calendar;
import java.util.Scanner;

public class Example11 {
    /*Напишите программу, в которой Пользователь вводит имя и год рождения,
    в программа отображает сообщение содержащее имя пользователя и его
    возраст.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your birth year: ");
        int birthYear = scanner.nextInt();
        int todayYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.printf("Your name is: %s\nYour age probably is %s\n",name, (todayYear - birthYear));

    }
}
