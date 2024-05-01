package laba5;

import java.util.Scanner;

public class Example4 {
    /*Напишите программу с классом, у которого есть символьное и
целочисленное поле. В классе должны быть описаны версии конструктора с
двумя аргументами (целое число и символ – определяют значения полей), а
также с одним аргументом типа double. В последнем случае действительная
часть аргумента определяет код символа (значение символьного поля), а
дробная часть (с учетом десятых и сотых) определяет значение
целочисленного поля. Например, если аргументом передается число 65.1267,
то значением символьного поля будет символ ‘A’ с годом 65, а
целочисленное поле получит значение 12 (в дробной части учитываются
только десятые и сотые).*/
    int integer;
    char symbol;

    public static void main(String[] args) {

        int inputNumber = 8;
        char symbol = 'i';
        Example4 withTwoArguments = new Example4(inputNumber, symbol);
        System.out.println(withTwoArguments);

        System.out.println();

        System.out.println("Enter an double: ");
        double doubleNumber = 98.45435346;
        Example4 withOneArgument = new Example4(doubleNumber);
        System.out.println(withOneArgument);

    }

    Example4(double input) {
        symbol = (char) Math.floor(input);
        integer = (int) ((input - Math.floor(input)) * 100);

    }

    Example4(int inputInteger, char inputSymbol) {
        this.integer = inputInteger;
        this.symbol = inputSymbol;
    }

    public String toString() {
        return "symbol: " + symbol + "\ninteger is: " + integer;
    }
}
