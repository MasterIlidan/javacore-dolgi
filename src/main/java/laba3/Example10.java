package laba3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Example10 {
    /*Напишите программу, в которой создается целочисленный
массив, заполняется случайными числами и после этого значения элементов
в массиве сортируются в порядке убывания значений.*/
    public static void main(String[] args) {
        ArrayList<Integer> list = integerArrayList(15);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
    private static ArrayList<Integer> integerArrayList(int size) {
        ArrayList<Integer> array = new ArrayList<>(size+1);

        Random random = new Random();
        int randomInt;

        while (array.size() < size) {
            randomInt = random.nextInt(100);
            if (randomInt % 5 == 2) {
                array.add(randomInt);
            }
        }
        return array;
    }
}
