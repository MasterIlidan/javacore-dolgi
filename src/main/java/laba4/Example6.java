package laba4;

import java.util.Random;

public class Example6 {
    /*Напишите программу, в
которой создается и инициализируется двумерный числовой массив. Затем из этого
массива удаляется строка и столбец (создается новый массив, в
котором по сравнению с исходным удалена одна строка и один
столбец). Индекс удаляемой строки и индекс удаляемого столбца
определяется с помощью генератора случайных чисел.*/
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = getInteger2DArray(random.nextInt(10), random.nextInt(10));

        System.out.println("Original Array: ");
        ArrayPrint.printArray(array);

        System.out.println();

        int deleteRow = random.nextInt(array.length);
        int deleteCol = random.nextInt(array[0].length);
        System.out.printf("Deleted row: %d, column: %d\n", deleteRow, deleteCol);

        ArrayPrint.printArray(deleteRowAndCol(array,
                deleteRow,
                deleteCol));
    }

    private static int[][] getInteger2DArray(int rows, int cols) {
        rows = rows == 0 ? 2 : rows;
        cols = cols == 0 ? 3 : cols;
        int[][] array = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        return array;
    }

    private static int[][] deleteRowAndCol(int[][] array, int deleteRow, int deleteCol) {
        int[][] newArray = new int[array.length - 1][array[0].length - 1];


        for (int row = 0; row < newArray.length; row++) {
            boolean deleteRowFound = false;
            int rowOffset = 0;

            if (row == deleteRow) {
                deleteRowFound = true;
                rowOffset = 1;
            }

            for (int col = 0; col < newArray[row].length; col++) {
                boolean deleteColFound = false;
                int colOffset = 0;

                if (col == deleteCol) {
                    deleteColFound = true;
                    colOffset = 1;
                }
                newArray[row][col] = array[row+rowOffset][col+colOffset];


            }
        }
        return newArray;
    }
}
