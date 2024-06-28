package laba11;

import java.util.Arrays;
import java.util.Random;

public class Example1 {
    public static void main(String[] args) {
        int[] intArray = new int[20];

        Random random = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(10000);
        }

        System.out.print("Source array is: ");
        for (int x:intArray) {
            System.out.print(" " + x + " ");
        }
        System.out.println();

        System.out.println("Filtering decimals...");

        intArray = getDecimalIntegers(intArray);

        System.out.print("Only decimals array is: ");
        for (int x:intArray) {
            System.out.print(" " + x + " ");
        }
    }
    public static int[] getDecimalIntegers(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).toArray();
    }
}
