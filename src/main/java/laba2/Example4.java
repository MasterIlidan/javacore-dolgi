package laba2;

import java.util.Scanner;

public class Example4 {
    /*Напишите программу, которая проверяет, попадает ли введение
    пользователем число в диапазон от 5 до 10 включительно.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a num to check:\n" +
                "is this number between 5 and 10?\n");
        int input = scanner.nextInt();

        System.out.printf("%b", input >= 5 & input <= 10);
    }
}
