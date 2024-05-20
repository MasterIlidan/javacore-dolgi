package laba8;

import java.io.*;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        try {
            new File("My").mkdir();
// Создание исходного файла numIsh.txt и запись в него чисел типа float
            File f1 = new File("My/numIsh.txt");
            f1.createNewFile();
            System.out.println(f1.getAbsolutePath());
            //Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
            Scanner sc = new Scanner(System.in);
            DataOutputStream wr =
                    new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            System.out.println("Сколько вещественных чисел записать в файл?");
            int count = sc.nextInt();
            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++) {
                wr.write((sc.nextFloat()+"\n").getBytes());
            }
            wr.flush();
            wr.close();
// Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
            File f2 = new File("My/numRez.txt");
            f2.createNewFile();
// поток для чтения из исходного файла numIsh.txt
            DataInputStream rd =
                    new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
// поток для записи в результирующий файл numRez.txt
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
            try {
                while (true) {
                    float number = rd.readFloat();
                    //чтение - запись из одного файла в другой
                    wr.writeFloat(number);
                    System.out.println("Число " + (float) number);
                }
            } catch (EOFException e) {

            }
            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException e) {
            System.out.println("End of file");
            e.printStackTrace();
        }
    }
}
