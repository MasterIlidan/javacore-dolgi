package laba3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Example6 {
    /*Напишите программу, в которой создается одномерный числовой
    массив и заполняется числами, которые при делении на 5 дают в остатке 2
            (числа 2, 7,12,17 и так далее). Размер массива вводится пользователем.
    Предусмотреть обработку ошибки, связанной с вводом некорректного
    значения.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        System.out.println("Enter the size of the array: ");
        size = scanner.nextInt();

        ArrayList<Integer> array = integerArrayList(size);

        System.out.println("Your array is: " + array);
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

