package laba13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example17 {
    public static void main(String[] args) {
        System.out.println("This program will sum numbers of byte type");
        Scanner scanner = new Scanner(System.in);
        int capacity = -1;
        while (capacity < 0) {
            try {
                System.out.print("Enter array size: ");
                if ((capacity = scanner.nextInt()) <= 0) {
                    System.out.println("Size can't be <= 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("That isn't a number. Enter a number! Example: 5\t99");
            }
        }

        byte[] byteArray = new byte[capacity];
        System.out.println("Enter byte numbers");
        for (int i = 0; i < byteArray.length; i++) {
            try {
                byteArray[i] = scanner.nextByte();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                i--;
                System.out.println("Enter a number in byte type! Example: 5\t-99\n" +
                        "Note: byte type is between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE);
            }
        }
        try {
            byte sum = getSumOfArray(byteArray);
            System.out.println("Sum of byte array is: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private static byte getSumOfArray(byte[] array) {
        int byteSum = 0;
        for (byte x : array) {
            byteSum += x;
        }
        if (byteSum > Byte.MAX_VALUE || byteSum < Byte.MIN_VALUE) throw new IllegalArgumentException(
                "Sum of input byte numbers exceeds byte max/min values");
        return (byte) byteSum;
    }
}
