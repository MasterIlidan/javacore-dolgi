package laba2;

import java.util.Scanner;

public class Example2 {
    /*Напишите программу, которая проверяет, удовлетворяет ли введенное
    пользователем число следующим критериям: при делении на 5 в остатке
    получается 2, а при делении на 7 в остатке получается 1*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a num to check:\n" +
                "is this number divide by 5 and remainder is 2?\n" +
                "is this number divide by 7 and remainder is 1?");
        int input = scanner.nextInt();

        System.out.printf("%b %b", input %5 == 2, input %7 == 1);
    }
}
