package laba2;

import java.util.Scanner;

public class Example3 {
    /*Напишите программу, которая проверяет, удовлетворяет ли введенное
    пользователем число следующим критериям: число делится на 4, и при
    этом оно не меньше 10*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a num to check:\n" +
                "is this number divide by 4?\n" +
                "is this number greater then 10?");
        int input = scanner.nextInt();

        System.out.printf("%b %b", input %4 == 0, input > 10);
    }
}
