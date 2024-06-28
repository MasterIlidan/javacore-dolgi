package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example10 {
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

        int lessThan = 15;
        System.out.println("Getting list of integers that less than  " + lessThan);
        List<Integer> integersLessThan = getIntegersLessThan(integerList, lessThan);

        System.out.println("Result list: ");
        for (int x:integersLessThan) {
            System.out.print(" " + x + " ");
        }
    }
    private static List<Integer> getIntegersLessThan(List<Integer> stringList, int max) {
        return stringList.stream().filter(x -> x < max)
                .collect(Collectors.toList());
    }
}
