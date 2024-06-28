package laba11;

import java.util.Arrays;
import java.util.Random;

public class Example2 {
    public static void main(String[] args) {
        int[] firstArray = new int[20];
        int[] secondArray = new int[20];

        Random random = new Random();
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = random.nextInt(100);
            secondArray[i] = random.nextInt(100);
        }

        System.out.print("First array is: ");
        for (int x:firstArray) {
            System.out.print(" " + x + " ");
        }
        System.out.println();
        System.out.print("Second array is: ");
        for (int x:secondArray) {
            System.out.print(" " + x + " ");
        }
        System.out.println();

        System.out.println("Filtering equal integers...");
        int[] equalInts = getEqualIntegers(firstArray, secondArray);

        System.out.print("Equal numbers from two arrays is: ");
        for (int x:equalInts) {
            System.out.print(" " + x + " ");
        }
    }
    private static int[] getEqualIntegers(int[] array1, int[] array2) {
        return Arrays.stream(array1).filter(x -> Arrays.stream(array2)
                .anyMatch(y -> x == y))
                .toArray();
    }
}
