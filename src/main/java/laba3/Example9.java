package laba3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example9 {
    /*Напишите программу, в которой создается массив и заполняется
случайными числами. Массив отображается в консольном окне. В этом
массиве необходимо определить элемент с минимальным значением. В
частности, программа должна вывести значение элемента с минимальным
значением и индекс этого элемента. Если элементов с минимальным
значением несколько, должны быть выведены индексы всех этих элементов.*/
    public static void main(String[] args) {
        ArrayList<Integer> list = integerArrayList();

        System.out.println("Array: " + list);

        System.out.println("Minimal is: " + Collections.min(list));

        System.out.println("Minimal at indexes: " + getMinimalElementsIndexes(list));


    }

    private static ArrayList<Integer> integerArrayList() {
        Random random = new Random();
        int size = random.nextInt(20);
        size = size == 0 ? 1 : size;
        ArrayList<Integer> list = new ArrayList<>(size + 1);

        while (list.size() < size) {
            list.add(random.nextInt(101));
        }
        return list;
    }

    private static ArrayList<Integer> getMinimalElementsIndexes(ArrayList<Integer> list) {
        int min = Collections.min(list);

        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == min) {
                indexes.add(i);
            }
        }
        return indexes;
    }

}
