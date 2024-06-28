package laba11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        String string = "Алекса́ндр Серге́евич Пу́шкин — русский9 поэт, " +
                "драматург и прозаик, заложивший основы русского реалистического направления, " +
                "литературный критик и теоретик литературы, историк, публицист, журналист, редактор " +
                "и издатель. Один из самых авторитетных литературных деятелей первой трети XIX века.";
        String[] strings = string.split(" ");
        List<String> stringList = new ArrayList<>(List.of(strings));
        System.out.println("Source string list is: ");
        for (int i = 0; i < stringList.size(); i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(" " + stringList.get(i) + " ");
        }
        System.out.println();

        System.out.println("Getting list of strings that has only characters...");
        List<String> listWithOnlyCharacters = getListWithOnlyCharacters(stringList);

        System.out.println("Only characters string list is: ");
        for (int i = 0; i < listWithOnlyCharacters.size(); i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(" " + listWithOnlyCharacters.get(i) + " ");
        }

    }

    private static List<String> getListWithOnlyCharacters(List<String> stringList) {
        return stringList.stream().filter(string -> Arrays.stream(string.chars().toArray())
                        .allMatch(x -> Character.isAlphabetic((char) x))
                )
                .collect(Collectors.toList());
    }
}
