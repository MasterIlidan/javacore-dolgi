package laba3;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
    /*Напишите программу, которая выводит последовательность
    чисел Фибоначчи. Первые два числа в этой последовательности равны 1, а
    каждое следующее число равно сумме двух предыдущих (получается по-
            следовательность 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 и так далее). Количество
    чисел в последовательности вводится пользователем. Предложите версии
    программы, использующие разные операторы цикла.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number of length of Fibonacci sequence: ");
        int input = scanner.nextInt();

        if (input < 0 ) return;
        if (input == 1) System.out.println("[1]");
        if (input == 2) System.out.println("[1, 1]");

        ArrayList<Integer> fibonacciSequence = getIntegers(input);
        System.out.println(fibonacciSequence);
    }

    private static ArrayList<Integer> getIntegers(int input) {
        ArrayList<Integer> fibonacciSequence = new ArrayList<>(input +1);
        fibonacciSequence.add(1);
        fibonacciSequence.add(1);

        for (int currentElement = 2; currentElement < input; currentElement++) {
            int sumOfPreviousElements = 0;

            for (int summingIndex = currentElement - 2; summingIndex < currentElement; summingIndex++) {
                sumOfPreviousElements += fibonacciSequence.get(summingIndex);
            }

            fibonacciSequence.add(currentElement, sumOfPreviousElements);
        }
        return fibonacciSequence;
    }
}
