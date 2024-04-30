package laba4;

public class ArrayPrint {
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }

    }
}
