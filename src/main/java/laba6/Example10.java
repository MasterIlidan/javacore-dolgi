package laba6;

import java.util.*;

public class Example10 {
    /*Напишите программу со статическим методом, аргументом которому передается
произвольное количество целочисленных аргументов. Результатом метод возвращает
массив из двух элементов: это значения наибольшего и наименьшего значений среди
аргументов, переданных методу.*/
    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Array: "+ Arrays.toString(nums));

        System.out.println("Min and max: " + Arrays.toString(maxAndMinFromSequence(nums)));
    }
    public static int[] maxAndMinFromSequence(int... sequence) {
        if (sequence.length == 0) return new int[]{0,0};
        if (sequence.length == 1) return sequence;
        int min = sequence[0];
        int max = sequence[0];
        for(int num:sequence) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return new int[]{min,max};
    }
}
