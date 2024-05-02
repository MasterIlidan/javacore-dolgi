package laba6;

import java.util.Arrays;

public class Example9 {
    /*Напишите программу со статическим методом, аргументом которому передается
одномерный символьный массив. В результате вызова метода элементы массива попарно
меняются местами: первый — с последним, второй — с предпоследним и так далее.*/
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println("Original array: "+Arrays.toString(chars));

        System.out.println("Swapped array: "+Arrays.toString(swap(chars)));

    }
    public static char[] swap(char[] chars) {
        char[] newChars = new char[chars.length];
        int oldArrayIndex = 0;
        for (int newArrayIndex = chars.length - 1; newArrayIndex >= 0; newArrayIndex--) {
            newChars[newArrayIndex] = chars[oldArrayIndex++];
        }
        return newChars;
    }
}
