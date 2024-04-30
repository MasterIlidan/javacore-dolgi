package laba3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Example7 {
    /*Напишите программу, в которой создается одномерный
символьный массив из 10 элементов. Массив заполняется буквами «через
одну», начиная с буквы ' а ': то есть массив заполняется буквами ' а ' , ' с ' , '
е ' , ' д ' и так далее. Отобразите массив в консольном окне в прямом и
обратном порядке. Размер массива задается переменной.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        System.out.println("Enter the size of the array: ");
        size = scanner.nextInt();

        ArrayList<Character> list = characterArrayList(size);
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        //a = 97, z = 122
    }
    private static ArrayList<Character> characterArrayList(int size) {
        ArrayList<Character> characterArrayList = new ArrayList<>(size + 1);
        char charToList = 'a';
        while (characterArrayList.size() < size) {
            characterArrayList.add(charToList);
            charToList += 2;
            if (charToList > 'z') {
                charToList = 'a';
            }
        }

        return characterArrayList;
    }
}
