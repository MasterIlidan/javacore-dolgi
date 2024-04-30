package laba3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Example5 {
    /*Напишите программу, в которой вычисляется сумма чисел,
    удовлетворяющих таким критериям: при делении числа на 5 в остатке
    получается 2, или при делении на 3 в остатке получается 1 Количество чисел
    в сумме вводится пользователем. Программа отображает числа, которые
    суммируются, и значение суммы. Предложите версии программы,
    использующие разные операторы цикла.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        System.out.println("Enter the size of the array.\n" +
                "Array will contain integers: When a number is divided by 5, the remainder is 2\n" +
                "and a number is divided by 3, the remainder is 1");
        size = scanner.nextInt();

        ArrayList<Integer> list = getArray(size);

        System.out.println("Your array is: " + list);
    }

    private static ArrayList<Integer> getArray(int size) {
        ArrayList<Integer> list = new ArrayList<>(size+1);
        Random random = new Random();
        int randomInt;

        while (list.size() < size) {
            randomInt = random.nextInt(100);

            if (randomInt % 5 == 2 || randomInt % 3 == 1) {
                list.add(randomInt);
            }

        }
        return list;
    }
}

