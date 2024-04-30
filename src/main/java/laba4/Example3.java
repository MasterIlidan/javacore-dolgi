package laba4;

public class Example3 {
    /*Напишите программу, в которой создается двумерный массив,
который выводи прямоугольник из цифр 2;*/
    public static void main(String[] args) {
        int[][] rectangle = printRectangle(10, 10);

        ArrayPrint.printArray(rectangle);
    }

    private static int[][] printRectangle(int height, int width) {
        int[][] rectangle = new int[height][width];
        if (height < 1) {
            System.out.println("Invalid height");
            return null;
        }
        if (width < 1) {
            System.out.println("Invalid width");
            return null;
        }

        for (int currentString = 0; currentString < height; currentString++) {

            for (int currentColumn = 0; currentColumn < width; currentColumn++) {

                if (currentString == 0 || currentString == (width - 1)) {
                    rectangle[currentColumn][currentString] = 2;
                }
                if (currentColumn == width - 1 || currentColumn == 0) {
                    rectangle[currentColumn][currentString] = 2;

                }
            }

        }
        return rectangle;
    }
}
