package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example8 {
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

        int biggerThan = 85;
        System.out.println("Getting list of integers that bigger than  " + biggerThan);
        List<Integer> integersBiggerThan = getIntegersBiggerThan(integerList, biggerThan);

        System.out.println("Result list: ");
        for (int x:integersBiggerThan) {
            System.out.print(" " + x + " ");
        }
    }
    private static List<Integer> getIntegersBiggerThan(List<Integer> stringList, int min) {
        return stringList.stream().filter(x -> x > min)
                .collect(Collectors.toList());
    }
}
