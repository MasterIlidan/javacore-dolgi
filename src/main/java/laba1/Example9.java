package laba1;

import java.util.HashMap;
import java.util.Scanner;

public class Example9 {
    /*Напишите программу, в которой пользователю предлагается ввести
    название месяца и количество дней в этом месяце. Программа выводит
    сообщение о том, что соответствующий месяц содержит указанное
    количество дней.*/
    public static void main(String[] args) {
        HashMap<String, Integer> monthsAndDays = getStringIntegerHashMap();


        Scanner scanner = new Scanner(System.in);
        String month;
        int monthDays;

        System.out.println("Enter a name of month: ");
        month = scanner.nextLine();

        if (!monthsAndDays.containsKey(month.toLowerCase())) {
            System.out.println("Month you typed doesn't exist");
            return;
        }

        System.out.println("Enter count of days in month: ");
        monthDays = scanner.nextInt();

        if (monthDays > 0 && monthDays <= monthsAndDays.get(month)) {
            System.out.println("This month can have this number of days");
        } else {
            System.out.println("This month can't have this number of days");
        }

    }

    private static HashMap<String, Integer> getStringIntegerHashMap() {
        HashMap<String, Integer> monthsAndDays = new HashMap<>();
        monthsAndDays.put("january", 31);
        monthsAndDays.put("february", 29);
        monthsAndDays.put("march", 31);
        monthsAndDays.put("april", 31);
        monthsAndDays.put("may", 31);
        monthsAndDays.put("june", 31);
        monthsAndDays.put("july", 31);
        monthsAndDays.put("august", 31);
        monthsAndDays.put("september", 31);
        monthsAndDays.put("november", 31);
        monthsAndDays.put("december", 31);
        return monthsAndDays;
    }
}
