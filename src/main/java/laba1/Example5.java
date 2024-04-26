package laba1;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input name: ");
        String name = scanner.nextLine();

        System.out.println("Input age: ");
        int age = scanner.nextInt();

        System.out.println("Input height: ");
        float height = scanner.nextFloat();

        System.out.printf("Name: %s\nAge: %d\nHeight: %f\n", name, age, height);
        scanner.close();
    }
}
