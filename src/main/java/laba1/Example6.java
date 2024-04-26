package laba1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        String firstName, secondName, surname;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter your second name: ");
        secondName = scanner.nextLine();
        System.out.print("Enter your surname: ");
        surname = scanner.nextLine();
        System.out.printf("Your first name is %s , your second name is %s, your surname is %s\n", firstName, secondName, surname);
    }
}
