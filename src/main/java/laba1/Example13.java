package laba1;

import java.util.Scanner;

public class Example13 {
    /*Напишите программу для вычисления суммы двух чисел. Оба числа
    вводятся пользователем. Для вычисления суммы используйте оператор +.*/
    public static void main(String[] args) {
        int num1, num2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number to sum: ");
        num1 = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter second number to sum: ");
        num2 = scanner.nextInt();

        System.out.printf("Sum of two numbers is: " + (num1 + num2));
    }
}
