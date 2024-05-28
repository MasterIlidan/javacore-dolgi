package laba9;
/*2 Создать приложение с использованием рекурсии для перевода
целого числа, введенного с клавиатуры, в двоичную систему счисления.*/
public class Example7 {
    public static void main(String[] args) {
        String result = convertToBinary(656456);
        //assert result.equals("10100000010001001000");
        System.out.println(result);
    }

    public static String convertToBinary(int num) {
        if (num == 1) return "1";
        if (num == 0) return "0";

        return convertToBinary(num / 2) + num % 2 ;
    }
}
