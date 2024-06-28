package laba11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
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

        String substring = "оза";

        System.out.println("Getting list that contain substring " + '"' + substring + '"');
        List<String> substringMatch = getSubstringMatchList(stringList, substring);

        System.out.println("Substring match list is: ");
        for (int i = 0; i < substringMatch.size(); i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(" " + substringMatch.get(i) + " ");
        }
    }
    private static List<String> getSubstringMatchList (List<String> stringList, String substring) {
        return stringList.stream().filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }
}
