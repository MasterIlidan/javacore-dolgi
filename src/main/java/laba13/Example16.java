package laba13;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Example16 {
    static int[][] matrix;

    public static void main(String[] args) {

        int rows = 5, cols = 6;
        matrix = getMatrix(rows, cols);
        System.out.println("Type exit to exit the program");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Matrix");
            for (int[] matrixRows : matrix) {
                for (int element : matrixRows) {
                    System.out.print(element + "\t");
                }
                System.out.println();
            }
            int row = Integer.MIN_VALUE, col = Integer.MIN_VALUE;

            while (row == Integer.MIN_VALUE) {
                try {
                    System.out.print("Enter row: ");
                    row = scanner.nextInt();
                } catch (InputMismatchException e) {
                    if (scanner.nextLine().equals("exit")) System.exit(0);
                    System.out.println("That isn't a number. Enter a number! Example: 5\t99");
                }
            }

            while (col == Integer.MIN_VALUE) {
                try {
                    if (scanner.nextLine().equals("exit")) System.exit(0);
                    System.out.print("Enter col: ");
                    col = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("That isn't a number. Enter a number! Example: 5\t99");
                }
            }

            try {
                int element = getMatrixElement(row, col);
                System.out.println("Your element: " + element);
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println("error: " + e.getMessage() + "\nNote: first element index is 0");
            }
            System.out.println("\n\n");
        }
    }

    private static int[][] getMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = random.nextInt(100);
            }
        }
        return matrix;
    }

    private static int getMatrixElement(int row, int col) {
        if (row < 0 || col < 0) throw new IllegalArgumentException("row or col cannot be less than 0");
        if (row > matrix.length & col > matrix[0].length)
            throw new ArrayIndexOutOfBoundsException(String.format("row %d and col %d don't exist", row, col));
        if (row > matrix.length) throw new ArrayIndexOutOfBoundsException(String.format("row %d is don't exist", row));
        if (col > matrix[0].length)
            throw new ArrayIndexOutOfBoundsException(String.format("col %d is don't exist", col));
        return matrix[row][col];
    }
}
