package laba3;

import java.util.Scanner;

public class Example2 {
    /*Напишите программу, в которой пользователю предлагается
    ввести название дня недели. По введенному названию программа определяет
    порядковый номер дня в неделе. Если пользователь вводит неправильное
    название дня, программа выводит сообщение о том, что такого дня нет.
    Предложите версию программы на основе вложенных условных операторов
    и на основе оператора выбора switch.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a day of week: ");
        String input = scanner.nextLine();

        switch (input.toLowerCase()) {
            case "monday" -> System.out.println("Today is 1 day of week");
            case "tuesday" -> System.out.println("Today is 2 day of week");
            case "wednesday" -> System.out.println("Today is 3 day of week");
            case "thursday" -> System.out.println("Today is 4 day of week");
            case "friday" -> System.out.println("Today is 5 day of week");
            case "saturday" -> System.out.println("Today is 6 day of week");
            case "sunday" -> System.out.println("Today is 7 day of week");
            default -> System.out.println("Wrong day of week. Try again");
        }
    }
}
