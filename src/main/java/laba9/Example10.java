package laba9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*6 Заполнить HashMap 10 объектами <Integer, String>. Найти строки
у которых ключ> 5 Если ключ = 0, вывести строки через запятую.
Перемножить все ключи, где длина строки>5.*/
public class Example10 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = getMap();


        System.out.println("Strings with key above 5");
        ArrayList<Integer> keysList = getKeysList(map);
        ArrayList<String> values = getValuesFromKeys(map, keysList);
        System.out.println(values);

        System.out.println();

        System.out.println("Multiplication of keys witch string value has length above 5");
        System.out.println(getMultiOfKeys(map, keysList));

        //System.out.println(map);
    }

    public static HashMap<Integer, String> getMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        return map;
    }

    public static ArrayList<Integer> getKeysList(HashMap<Integer, String> map) {
        Set<Integer> keySet = map.keySet();

        ArrayList<Integer> keys = new ArrayList<>();
        for (Integer key : keySet) {
            if (key > 5) keys.add(key);
        }
        return keys;
    }

    public static ArrayList<String> getValuesFromKeys(HashMap<Integer, String> map,
                                                      ArrayList<Integer> keys) {
        ArrayList<String> values = new ArrayList<>();
        for (Integer key : keys) {
            values.add(map.get(key));
        }
        return values;
    }

    public static int getMultiOfKeys(HashMap<Integer, String> map, ArrayList<Integer> keys) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (Integer key : keys) {
            if (map.get(key).length() > 5) ints.add(key);
        }
        if (ints.isEmpty()) return 0;
        int multi = 1;
        for (Integer key : ints) {
            multi *= key;
        }
        return multi;
    }
}
