package laba3;

import java.util.Scanner;

public class Example1 {
    /*Напишите программу, в которой пользователь вводит целое
    число в диапазоне от 1 до 7, а программа определяет по этому числу день
    недели. Если введенное пользователем число выходит за допустимый
    диапазон, выводится сообщение о том, что введено некорректное значение.
    Используйте оператор выбора switch.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number of day of week: ");
        int input = scanner.nextInt();

        switch (input) {
            case 1 -> System.out.println("Today is Monday");
            case 2 -> System.out.println("Today is Tuesday");
            case 3 -> System.out.println("Today is Wednesday");
            case 4 -> System.out.println("Today is Thursday");
            case 5 -> System.out.println("Today is Friday");
            case 6 -> System.out.println("Today is Saturday");
            case 7 -> System.out.println("Today is Sunday");
            default -> System.out.println("Wrong number. Try again");
        }
    }
}
