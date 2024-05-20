package laba9;
/*Пример 2
Вывести последовательность, представленную в
предыдущем примере, в обратном порядке. На рисунке 2 представлен
результат выполнения примера 2*/
public class Example2 {
    public static void main(String[] args) {
        function(1);
    }
    public static void function(int x) {
        if ((2 * x + 1) < 20) {
            function(2 * x + 1);
        }
        System.out.println("x = " + x);
    }
}
