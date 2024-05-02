package laba6;

public class Example5 {
    /*Напишите программу со статическим методом, которым вычисляется сумма
квадратов натуральных чисел 12 + 22 + 32 + ... + п2. Число п передается аргументом методу.
Для проверки результата можно использовать формулу 12 + 22 +32+…+n2 =(n+l) (2n +
1)/6*/
    public static void main(String[] args) {
        int num = 10;
        System.out.println(sumOfSquares(num));
        System.out.println(check(num));
    }
    public static int sumOfSquares(int num) {
        if (num <= 1) return 1;
        else
            return (int) Math.pow(num,2) + sumOfSquares(num - 1);
    }
    public static int check(int num) {
        return (num * (num + 1) * (2* num + 1)) / 6;
    }
}
