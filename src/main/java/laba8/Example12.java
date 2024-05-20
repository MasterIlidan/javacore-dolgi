package laba8;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/*Задание 3 Создать проект, позволяющий из одного текстового
файла, содержащего несколько строк (тип String) заранее
подготовленного текста на русском языке (Пушкин, Лермонтов или
другой российский классик на Ваш вкус), построчно переписать в другой
текстовый файл слова начинающиеся с согласных букв.
Требования:
– слова из предложения выделять методом split();
– в новом файле следует указать номер строки, в которой искомые
слова находились в исходном файле;
– для каждой строки указать количество выбранных слов.*/
public class Example12 {
    public static void main(String[] args) {
        ArrayList<Character> characterArrayList = getCharList();
        String line;
        int lineCounter = 1;
        int found;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Input.txt")));
             PrintWriter writer = new PrintWriter("Output.txt", StandardCharsets.UTF_8)) {

            while ((line = reader.readLine()) != null) {
                StringBuilder lineToWrite = new StringBuilder();
                found = 0;

                for (String word : line.split(" ")) { //ищем слова на согласную
                    if (characterArrayList.contains(word.charAt(0))) {
                        found++; //прибавили счетчик найденного на строке
                        lineToWrite.append(word).append(" "); //записали в строку слово
                    }
                }
                if (!lineToWrite.toString().isEmpty()) {
                    writer.println(lineToWrite + "(строка " + lineCounter + "), найдено в строке " + found); //записали строку со словами в файл
                }
                lineCounter++; //счетчик строк
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Character> getCharList() {
        String charList = "Б,В,Г,Д,Ж,З,Й,К,Л,М,Н,П,Р,С,Т,Ф,Х,Ц,Ч,Ш,Щ";
        charList = charList + "," + charList.toLowerCase();
        ArrayList<Character> characterArrayList = new ArrayList<>(42);
        String[] words = charList.split(",");

        for (String word : words) {
            characterArrayList.add(word.charAt(0));
        }
        return characterArrayList;
    }
}
