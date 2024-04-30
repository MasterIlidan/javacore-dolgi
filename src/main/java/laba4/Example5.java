package laba4;

import java.util.Random;

public class Example5 {
    /*Напишите программу, в которой создается двумерный
целочисленный массив. Он заполняется случайными числами.
Затем в этом массиве строи и столбцы меняются местами: первая
строка становится первым столбцом, вторая строка становиться
вторым столбцом и так далее. Например, если исходный массив
состоял из 3 строк и 5 столбцов, то в итоге получаем массив из 5
строк и 3 столбцов.*/
    public static void main(String[] args) {
        int[][] array = getInteger2DArray(5,3);

        System.out.println("Original Array:");
        ArrayPrint.printArray(array);

        System.out.println();

        System.out.println("Flipped Array");
        ArrayPrint.printArray(flipArray(array));


    }
    private static int[][] getInteger2DArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        return array;
    }

    private static int[][] flipArray(int[][] array) {
        int[][] flippedArray = new int[array[0].length][array.length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                flippedArray[col][row] = array[row][col];
            }
        }
        return flippedArray;
    }
}
