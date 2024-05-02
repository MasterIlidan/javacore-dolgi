package laba6;

import java.util.Arrays;

public class Example7 {
    /*Напишите программу со статическим методом, аргументом которому передастся
символьный массив, а результатом возвращается ссылка на целочисленным массив,
состоящий из кодов символов из массива- аргумента.*/
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println("Char array: " + Arrays.toString(chars));

        System.out.println("Int array from char array: " + Arrays.toString(getIntArray(chars)));
    }

    public static int[] getIntArray(char[] chars) {
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = (int) chars[i];
        }
        return ints;
    }
}
