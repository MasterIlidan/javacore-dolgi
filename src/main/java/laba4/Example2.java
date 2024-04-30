package laba4;

public class Example2 {
    /*Напишите программу, которая выводит в консольное окно
прямоугольный треугольник;*/
    public static void main(String[] args) {
        printTriangle(10);
    }

    private static void printTriangle(int height) {
        if (height < 1) {
            System.out.println("Invalid height");
            return;
        }

        char printChar = '+';
        //char fillChar = ' ';

        for (int currentString = 1; currentString <= height; currentString++) {

            for (int countOfPrints = 1; countOfPrints <= currentString; countOfPrints++) {
                System.out.print(printChar);
            }
            System.out.println();
        }

    }
}

