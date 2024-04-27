package laba2;

import java.util.Scanner;

public class Example5 {
    /*Напишите программу, которая проверяет, сколько тысяч во введенном
    пользователем числе (определяется четвертая цифра справа в десятичном
            представлении числа).*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to calculate how many thousands it have: ");
        int input = scanner.nextInt();

        System.out.printf("Your number has %s thousands", input/1000);
    }
}
