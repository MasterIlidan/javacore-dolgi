package laba4;

import java.util.Scanner;

public class Example8 {
    /*Напишите программу «Шифр Цезаря», которая
зашифровывает введенный текст. Используете кодовую таблицу
символов. При запуске программы в консоль необходимо вывести
сообщение: «Введите текст для шифрования», после ввода текста,
появляется сообщение: «Введите ключ». После того как введены
все данные, необходимо вывести преобразованную строку с
сообщением «Текст после преобразования: ». Далее необходимо
задать вопрос пользователю: «Выполнить обратное
преобразование? (y/n)», если пользователь вводит «y», тогда
выполнить обратное преобразование. Если пользователь вводит
«n», того программа выводит сообщение «До свидания!». Если
пользователь вводит что-то другое, отличное от «y» или «n», то
программа ему выводит сообщение: «Введите корректный ответ».*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Choose option(1-3)\n" +
                    "1. Encrypt text\n" +
                    "2. Decrypt text\n" +
                    "3. Exit");

            switch (scanner.nextInt()) {
                case 1: {
                    scanner.nextLine();
                    System.out.println("Enter text");
                    String textToEncrypt = scanner.nextLine();
                    System.out.println("Enter key (number):");
                    int key = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Your text encrypted: " + encrypt(textToEncrypt, key) +
                            "\nYour key: " + key +
                            "\nDon't forget it!");
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("Enter text");
                    String textToDecrypt = scanner.nextLine();
                    System.out.println("Enter key (number):");
                    int key = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Your text decrypted: " + decrypt(textToDecrypt, key));
                    break;
                }
                case 3: {
                    System.out.println("Bye.");
                    return;
                }
                default: {
                    scanner.nextLine();
                    System.out.println("Invalid option!");
                    break;
                }

            }

        }
    }

    private static String encrypt(String textToEncrypt, int key) {
        char[] chars = textToEncrypt.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);
        }
        return new String(chars);
    }

    private static String decrypt(String textToDecrypt, int key) {
        char[] chars = textToDecrypt.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key);
        }
        return new String(chars);
    }
}
