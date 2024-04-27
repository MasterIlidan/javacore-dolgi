package laba2;

import java.util.Scanner;

public class Example1 {
    /*Напишите программу, которая проверяет, делится ли введенное
    Пользователем число на 3*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a num to check is this number divide by 3: ");
        int input = scanner.nextInt();

        if (input % 3 == 0) {
            System.out.println("Number you typed is dividable by 3");
        } else {
            System.out.println("Number you typed isn't dividable by 3");
        }
    }
}
