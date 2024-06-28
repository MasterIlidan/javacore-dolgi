package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example6 {
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

        int divide = 9;
        System.out.println("Filtering integers that can be divided by " + divide+ "...");
        List<Integer> dividableList = getDividableIntegerList(integerList, divide);

        System.out.println("Result list: ");
        for (int x:dividableList) {
            System.out.print(" " + x + " ");
        }
    }
    private static List<Integer> getDividableIntegerList(List<Integer> integerList, int divide) {
        return integerList.stream().filter(x -> x % divide == 0).collect(Collectors.toList());
    }
}
