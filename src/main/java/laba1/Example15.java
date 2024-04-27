package laba1;

import java.util.Scanner;

public class Example15 {
    /*Напишите программу, в которой Пользователь вводит два числа, а
    программой вычисляется и отображается сумма и разность этих чисел.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.println("Enter first number: ");
        num1 = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter second number: ");
        num2 = scanner.nextInt();

        System.out.println("Sum of two numbers: " + (num1 + num2));
        System.out.println("Difference of two numbers: " + (num1 - num2));
    }
}
