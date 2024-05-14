package laba8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Example3 {
    /*Пример 3 Прочитать и вывести на экран информацию из предварительно
созданного файла с использованием буфера в 5 байт.*/
    public static void readAllByArray(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        while (true) {
            int count = in.read(buff);
            if (count != -1) {
                System.out.println("Количесвто = " + count + ", buff = " + Arrays.toString(buff) + ", str = " + new String(buff, 0, count));
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "MyFile1.txt";

        try (InputStream inFile = new FileInputStream(filename)) {
            readAllByArray(inFile);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода файла " + filename + e);
        }
    }
}
