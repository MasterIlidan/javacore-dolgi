package laba7;

public class Example1 {
    /*Напишите программу, в которой есть суперкласс с приватным текстовым полем,
конструктором с текстовым параметром и где переопределен метод toString (). На основе
суперкласса путем наследования создается подкласс. У него появляется еще одно
приватное текстовое ноле. Также подкласс должен иметь версии конструктора с одним и
двумя текстовыми аргументами, а еще в нем должен быть переопределен метод toString ().
В обоих классах метод toString () переопределяется так, что он возвращает строку с
названием класса и значение текстового поля или текстовых полей.*/

    public static void main(String[] args) {
        SubExample1 subExample1 = new SubExample1("Hello World");
        SubExample1 subExample2 = new SubExample1("Hello", "World");

        System.out.println(subExample1);
        System.out.println();
        System.out.println(subExample2);
    }
}

class SubExample1 extends SuperExample1 {

    private final String textField;

    SubExample1(String textField) {
        super(textField);
        this.textField = "";
    }

    SubExample1(String textField1, String textField2) {
        super(textField1);
        this.textField = textField2;
    }

    @Override
    public String toString() {
        return getClass().getName() + " textField=" + textField + "\n" + super.toString();
    }
}

class SuperExample1 {
    private final String textField;

    SuperExample1(String textField) {
        this.textField = textField;
    }

    @Override
    public String toString() {
        return getClass().getSuperclass().getName() + " textField=" + textField;
    }
}
