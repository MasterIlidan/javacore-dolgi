package laba6;

import java.util.Arrays;

public class Example6 {
    /*Напишите программу со статическим методом, которому аргументом передается
целочисленный массив и целое число. Результатом метод возвращает ссылку на новый
массив, который получается из исходного массива (переданного первым аргументом
методу), если в нем взять несколько начальных элементов. Количество элементов,
которые нужно взять из исходного массива, определяются вторым аргументом метода.
Если второй аргумент метода больше длины массива, переданного первым аргументом, то
методом создается копия исходного массива и возвращается ссылка на эту копию.*/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(nums));

        System.out.println("Get new array with 3 first elements from original array " + Arrays.toString(getNewArray(nums, 3)));

        System.out.println("If the length of original array less then wanted length: " + Arrays.toString(getNewArray(nums, 10)));

    }

    public static int[] getNewArray(int[] nums, int length) {
        if (nums.length < length) {
            return nums;
        }
        return Arrays.copyOfRange(nums, 0, length);
    }
}
