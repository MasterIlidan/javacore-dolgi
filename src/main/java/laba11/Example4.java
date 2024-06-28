package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example4 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            integerList.add(random.nextInt(100));
        }

        System.out.print("Source list is: ");
        for (int x:integerList) {
            System.out.print(" " + x + " ");
        }

        System.out.println();
        System.out.println("Square all integers in list...");

        integerList = squareAllIntegersInList(integerList);

        System.out.println("Now list is: ");
        for (int x:integerList) {
            System.out.print(" " + x + " ");
        }
    }
    private static List<Integer> squareAllIntegersInList(List<Integer> integerList) {
        return integerList.stream().map(x -> x*x).collect(Collectors.toList());
    }
}
