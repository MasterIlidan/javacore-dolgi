package laba6;

public class Example1 {
    /*Напишите программу с классом, в котором есть два поля: символьное и текстовое.
В классе должен быть перегруженный метод для присваивания значений полям. Если
метод вызывается с символьным аргументом, то соответствующее значение присваивается
символьному полю. Если метод вызывается с текстовым аргументом, то он определяет
значение текстового ноля. Методу аргументом также может передаваться символьный
массив. Если массив состоит из одного элемента, то он определяет значение символьного
поля. В противном случае (если в массиве больше одного элемента) из символов массива
формируется текстовая строка и присваивается значением текстовому полю.*/
    static char symbol;
    static String string;

    public static void main(String[] args) {
        System.out.println("Method with char argument");
        setValue('T');
        System.out.println("Symbol is: " + symbol);

        System.out.println("Method with String argument");
        setValue("Hello world");
        System.out.println("String is: " + string);

        System.out.println("Method with char array argument with length 1");
        setValue(new char[]{'A'});
        System.out.println("Symbol is: " + symbol);

        System.out.println("Method with char array argument with length more then 1");
        setValue(new char[]{'A', 'B', 'C'});
        System.out.println("String is: " + string);
    }

    public static void setValue(char input) {
        symbol = input;
    }
    public static void setValue(String input) {
        string = input;
    }
    public static void setValue(char[] input) {
        if (input.length == 1) {
            symbol = input[0];
        } else {
            string = new String(input);
        }
    }

}
