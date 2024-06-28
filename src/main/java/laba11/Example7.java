package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Example7 {
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

        int minLength = 9;
        System.out.println("Getting list of strings that length bigger than  " + minLength);
        List<String> stringsByLength = getStringsByLength(stringList, minLength);

        System.out.println("Substring match list is: ");
        for (int i = 0; i < stringsByLength.size(); i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(" " + stringsByLength.get(i) + " ");
        }

    }
    private static List<String> getStringsByLength (List<String> stringList,int minLength) {
        return stringList.stream().filter(string -> string.length() > minLength)
                .collect(Collectors.toList());
    }
}
