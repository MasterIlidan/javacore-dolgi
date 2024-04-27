package timus.task_1293;

import java.util.Scanner;

//В рамках первой лабы
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPanels, wightOfPanel, heightOfPanel;

        String[] input = scanner.nextLine().split(" ");
        countOfPanels = Integer.parseInt(input[0]);
        wightOfPanel = Integer.parseInt(input[1]);
        heightOfPanel = Integer.parseInt(input[2]);

        System.out.println(countOfPanels * wightOfPanel * heightOfPanel * 2);
    }
}
