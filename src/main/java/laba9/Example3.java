package laba9;
/*Пример 3 Код вывода параметра перед вхождением в рекурсивный вызов
и после него, показан на рисунке 3*/
public class Example3 {
    private static int step = 0;
    public static void main(String[] args) {
        function(1);
    }

    public static void function(int x) {
        space();
        System.out.println(x + "-> ");
        step++;
        if ((2 * x + 1) < 20) {
            function(2 * x + 1);
        }
        step--;
        space();
        System.out.println(x + "<-");
    }

    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }
}
