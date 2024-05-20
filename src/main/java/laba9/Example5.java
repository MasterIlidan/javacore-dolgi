package laba9;
/*Пример 5 Вывести число Фибоначчи, заданное его номером в
последовательности.
Последовательность Фибоначчи формируется так: нулевой член
последовательности равен нулю, первый – единице, а каждый следующий
– сумме двух предыдущих.*/
public class Example5 {
    public static void main(String[] args) {
        System.out.println(fact(90));

    }
    
    public static int fact(int x) {
        System.out.println(x);
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fact(x - 2) + fact(x - 1);
        }
    }
}
