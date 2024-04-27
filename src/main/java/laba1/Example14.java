package laba1;

import java.util.Scanner;

public class Example14 {
    /*Напишите программу, в которой пользователь вводит число, а программой
    отображается последовательность из четырех чисел: число, на единицу
    меньше введённого, введенное число и число, на единицу больше
    введенного. Четвертое число должно быть квадратом суммы первых трех
    чисел.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lessNum, num, greaterNum, powNum;

        System.out.println("Enter a number: ");
        num = scanner.nextInt();

        lessNum = num - 1;
        greaterNum = num + 1;
        powNum = (int) Math.pow((lessNum + num + greaterNum), 2);

        System.out.printf("%s %s %s %s", lessNum, num, greaterNum, powNum);

    }
}
