package timus.task_1068;

import java.util.Scanner;
//В рамках второй лабы
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = Integer.parseInt(in.nextLine());
        if (result > 0)
            System.out.println((result * (result + 1)) / 2);

        else {
            result = Math.abs(result);
            System.out.println(1 - (result * (result + 1) / 2));
        }

    }
}