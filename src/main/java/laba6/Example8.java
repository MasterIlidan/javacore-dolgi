package laba6;

import java.util.Arrays;

public class Example8 {
    /*Напишите программу со статическим методом, аргументом которому передается
целочисленный массив, а результатом возвращается среднее значение для элементов
массива (сумма значений элементов, деленная на количество элементов в массиве).*/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Array: " + Arrays.toString(nums));

        System.out.println("Avg of this array: " + avgFromArray(nums));
    }

    public static double avgFromArray(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return (double) sum / nums.length;
    }
}
