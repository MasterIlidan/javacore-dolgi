package laba4;

import java.util.Random;

public class Example7 {
    /*Напишите программу, в которой создается двумерный
числовой массив и этот массив заполняется «змейкой»: сначала
первая строка (слева направо), затем последний столбец (сверху
вниз), вторая строка (справа налево) и так далее, как показано на
рисунке:*/
    public static void main(String[] args) {
        int[][] array = snakeFill(5, 5);

        ArrayPrint.printArray(array);
    }

    private static int[][] snakeFill(int rows, int cols) {
        int[][] array = new int[rows][cols];
        Random random = new Random();

        for (int row = 0; row < rows; row++) {

            if (row % 2 == 0) {

                for (int col = 0; col < cols; col++) {
                    array[row][col] = random.nextInt(100);
                }

            } else {
                for (int col = array.length - 1; col >= 0; col--) {
                    array[row][col] = random.nextInt(100);
                }

            }

        }


        return array;
    }
}
