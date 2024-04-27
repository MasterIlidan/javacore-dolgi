package laba3;

import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
    /*Напишите программу, в которой пользователем вводится два
    целых числа. Программа выводит все целые числа — начиная с наименьшего
            (из двух введенных чисел) и заканчивая наибольшим (из двух введенных
    чисел). Предложите разные версии программы (с использованием разных
            операторов цикла).*/
    public static void main(String[] args) {
       Sequence sequence = new Sequence();
        System.out.println(sequence.getSequence());
    }
}

class Sequence {
    private final int maxOfSequence;
    private final int minOfSequence;

    private final ArrayList<Integer> sequence;
    Sequence() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a max number of sequence: ");
        int firstInput = scanner.nextInt();

        System.out.println("Enter a min number of sequence: ");
        int secondInput = scanner.nextInt();

        maxOfSequence = Math.max(firstInput, secondInput);
        minOfSequence = Math.min(firstInput, secondInput);
        sequence = makeSequence();
    }
    private ArrayList<Integer> makeSequence() {
        ArrayList<Integer> sequenceList = new ArrayList<>(maxOfSequence - minOfSequence + 1);

        for (int putNumber = minOfSequence; putNumber <= maxOfSequence; putNumber++) {
            sequenceList.add(putNumber);
        }

        return sequenceList;
    }
    public ArrayList<Integer> getSequence() {
        return sequence;
    }
}
