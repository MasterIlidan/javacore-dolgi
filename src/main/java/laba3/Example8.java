package laba3;

import java.util.ArrayList;
import java.util.Arrays;

public class Example8 {
    /*Напишите программу, в которой создается символьный массив из
10 элементов. Массив заполнить большими (прописными) буквами
английского алфавита. Буквы берутся подряд, но только согласные (то есть
гласные буквы ’ А ' , 1 Е ' и ' I ' при присваивании значений элементам
массива нужно пропустить). Отобразите содержимое созданного массива в
консольном окне.*/
    public static void main(String[] args) {
        ArrayList<Character> consonantsCharacterList = new ArrayList<>();
        char charToAdd = 'A';

        ArrayList<Character> exceptions = exceptionArrayList();

        while (consonantsCharacterList.size() <= 10) {
            if (!exceptions.contains(charToAdd)) {
                consonantsCharacterList.add(charToAdd);
            }
            charToAdd++;
            if (charToAdd > 'Z') charToAdd = 'A';
        }

        System.out.println("List of consonants characters:" + consonantsCharacterList);
    }

    private static ArrayList<Character> exceptionArrayList() {
        Character[] t = {'A', 'E', 'I', 'O', 'U', 'Y'};

        return new ArrayList<>(Arrays.asList(t));
    }
}
