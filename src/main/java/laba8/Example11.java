package laba8;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*Задание 2 Создать проект, позволяющий из одного,
предварительно созданного программными средствами файла, переписать
данные, соответствующие условию - в исходном файле содержится две
строки в формате UTF-8 и 5 чисел типа double. В результирующий файл
переписать вторую строку и положительные числа.*/
public class Example11 {
    public static void main(String[] args) {

        //----------------------сгенерировать файлы----------------------
        try {
            File inputFile = new File("Input.txt");
            System.out.println("New input file created: " + inputFile.createNewFile());
            PrintWriter inputFileFill = new PrintWriter(new FileWriter(inputFile));
            inputFileFill.println("Privet\n" +
                    "Привет\n" +
                    "-454532.32434\n" +
                    "12.0003434\n" +
                    "-13242.3433576788\n" +
                    "4545.020123\n" +
                    "0");
            System.out.println("Input file created");

            File outputFile = new File("Output.txt");
            System.out.println("New output file created: " + outputFile.createNewFile());

            inputFileFill.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //----------------------

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Input.txt")));
             PrintWriter writer = new PrintWriter("Output.txt", StandardCharsets.UTF_8)) {
            String line;
            int lineCount = 1;
            while ((line = reader.readLine()) != null) {
                if (lineCount == 1) {
                    lineCount++;
                    continue;} //пропуск первой строки
                if (lineCount == 2) {//запись второй строки
                    writer.println(line);
                    lineCount++;
                    continue;
                }
                if (Float.parseFloat(line) > 0) writer.write(line + "\n");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
