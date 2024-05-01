package laba6;

public class Example2 {
    /*Напишите программу с классом, в котором есть закрытое статическое
целочисленное ноле с начальным нулевым значением. В классе должен быть описан
статический метод, при вызове которого отображается текущее значение статического
поля, после чего значение поля увеличивается на единицу.*/
    private static int num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Static num is: " + getNumWithIncrement());
        }

    }
    public static int getNumWithIncrement() {
        return num++;
    }
}
