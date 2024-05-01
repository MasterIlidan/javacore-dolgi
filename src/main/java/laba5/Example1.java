package laba5;

import java.util.Scanner;

public class Example1 {
    /*Напишите программу с классом, в котором есть закрытое символьное поле
и три открытых метода. Один из методов позволяет присвоить значение
полю. Еще один метод при вызове возвращает результатом код символа.
Третий метод позволяет вывести в консольное окно символ (значение поля) и
его код.*/
    private static char symbol;

    public static void main(String[] args) {
        setSymbol('t');
        System.out.println(getSymbol());
        printSymbol();
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void setSymbol(char symbol) {
        Example1.symbol = symbol;
    }

    public static void printSymbol() {
        System.out.println(symbol);
    }
}
