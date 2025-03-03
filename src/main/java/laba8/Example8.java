package laba8;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/*Пример 8 Прочитать и вывести на экран информацию из трех источников:
файла на диске, интернет-страницы и массива данных типа byte. Указать
кодировку, поддерживающую кириллицу. (Сравнить с работой программы,
приведенной в примере 2.)*/
public class Example8 {
    public static void readAllByByte(Reader in)
            throws IOException {
        while (true) {
            int oneByte = in.read();// читает 1 байт
            if (oneByte != -1) {// признак конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + " конец ");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
// С потоком связан файл
            InputStream inFile = new FileInputStream("MyFile1.txt");// байтовый поток
            Reader rFile = new InputStreamReader(inFile, "cp1251");// символьный поток. передается «русская» кодировка
            //Reader rFile = new InputStreamReader(inFile, StandardCharsets.UTF_8);// символьный поток. передается «русская» кодировка
            readAllByByte(rFile);
            System.out.print("\n\n\n");
            inFile.close();
            rFile.close();
// С потоком связана интернет-страница
            InputStream inUrl = new URL("http://google.com").openStream(); // байтовый поток
            Reader rUrl = new InputStreamReader(inUrl, "cp1251");// символьный поток
            //Reader rUrl = new InputStreamReader(inUrl, StandardCharsets.UTF_8);// символьный поток
            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();
// С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[]{5, 8, 3, 9, 11});
            Reader rArray = new InputStreamReader(inArray, "cp1251"); // символьный поток
            //Reader rArray = new InputStreamReader(inArray, StandardCharsets.UTF_8); // символьный поток
            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}

