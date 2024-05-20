package laba8;

import java.io.*;

/*Пример 7 Чтение из одного файла и запись в другой файл данных построчно с использованием буфера в 1 килобайт.*/
public class Example7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;
        try {
            br = new BufferedReader(new FileReader("MyFile1.txt"));
            out = new BufferedWriter(new FileWriter("MyFile2.txt"));

            int lineCount = 0;
            String s;

            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                out.write(s);
                out.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            br.close();
            out.flush();
            out.flush();
        }
    }
}
