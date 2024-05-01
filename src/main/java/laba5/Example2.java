package laba5;

import java.util.Scanner;

public class Example2 {
    /*Напишите программу с классом, у которого есть два символьных поля и
метод. Он возвращает результат, и у него нет аргументов. При вызове метод
выводит в консольное окно все символы из кодовой таблицы, которые
находятся «между» символами, являющимися значениями полей объекта (из
которого вызывается метод). Например, если полям объекта присвоены
значения ‘A’ и ‘D’, то при вызове метода в консольное окно должны
выводиться все символы от ‘A’ до ‘D’ включительно.*/
    private static char lowBound;
    private static char highBound;

    public static void main(String[] args) {
        lowBound = 'A';
        highBound = 'Z';
        printChars();
    }

    private static void printChars() {
        for (char i = lowBound; i <= highBound; i++) {
            System.out.print(i + " ");
        }
    }

}
