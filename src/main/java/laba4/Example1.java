package laba4;

public class Example1 {
    /*Напишите программу, которая выводить в консольное окно
прямоугольник, размеры сторон которого, ширина: 23 колонки,
высота: 11 строк;*/
    public static void main(String[] args) {
        /*System.out.println("+++++++++++++++");
        System.out.println("+             +");*/
        printRectangle(1, 5);
    }

    private static void printRectangle(int height, int width) {
        if (height < 1) {
            System.out.println("Invalid height");
            return;
        }
        if (width < 1) {
            System.out.println("Invalid width");
            return;
        }

        char printChar = '+';
        char fillChar = ' ';

        for (int currentString = 0; currentString < height; currentString++) {

            for (int currentColumn = 0; currentColumn < width; currentColumn++) {

                if (currentString == 0 || currentString == (width - 1)) {
                    System.out.print(printChar);
                } else {
                    if (currentColumn == width - 1 || currentColumn == 0) {
                        System.out.print(printChar);
                    } else {
                        System.out.print(fillChar);
                    }
                }
            }

            System.out.println();
        }
    }
}
