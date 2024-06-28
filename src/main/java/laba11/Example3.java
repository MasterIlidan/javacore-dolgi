package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
        String string = "Алекса́ндр Серге́евич Пу́шкин — русский поэт, " +
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
        System.out.println("Filtering strings that begin with upper case character...");

        List<String> upperCaseStringList = getUpperCaseStringList(stringList);
        System.out.println("Result: ");
        for (int i = 0; i < upperCaseStringList.size(); i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(" " + upperCaseStringList.get(i) + " ");
        }
    }

    private static List<String> getUpperCaseStringList(List<String> stringList) {
        return stringList.stream().filter(string -> Character.isUpperCase(string.charAt(0)))
                .collect(Collectors.toList());
    }
}
