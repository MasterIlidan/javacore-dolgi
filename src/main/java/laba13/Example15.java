package laba13;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        System.out.println("Enter 5 integers to calculate average sum");

        int capacity = 5;
        int[] inputInts = getInputArray(capacity);

        System.out.println("Calculating average sum of positive numbers...");

        try {
            double average = averageOfPositiveInts(inputInts);
            System.out.println("Average sum is " + average);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static double averageOfPositiveInts(int[] array) {
        int[] positiveArray = Arrays.stream(array).filter(x -> x > 0).toArray();
        if (positiveArray.length == 0) {
            throw new IllegalArgumentException("Input array don't have any positive numbers");
        }
        return (double) Arrays.stream(positiveArray).sum() / positiveArray.length;
    }

    private static int[] getInputArray(int capacity) {
        Scanner scanner = new Scanner(System.in);
        int[] inputInts = new int[capacity];
        for (int i = 0; i < inputInts.length; i++) {
            try {
                inputInts[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That isn't a number. Enter a number! Example: 5\t-10\t 9459");
                scanner.nextLine();
                i--;
            }
        }
        return inputInts;
    }
}
