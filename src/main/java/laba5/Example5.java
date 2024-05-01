package laba5;

public class Example5 {
    /*Напишите программу с классом, у которого есть закрытое целочисленное
поле. Значение полю присваивается с помощью открытого метода. Методу
аргументом может передаваться целое число, а также метод может
вызываться без аргументов. Если методы вызывается без аргументов, то поле
получает нулевое значение. Если метод вызывается с целочисленным
аргументом, то это значение присваивается полю. Однако если переданное
аргументом методу значение превышает 100, то значением полю
присваивается число 100 Предусмотрите в классе конструктор, который
работает по тому же принципу что и метод для присваивания значения полю.
Также в классе должен быть метод, позволяющий проверить значение поля.*/
    private int integer;

    public static void main(String[] args) {

        System.out.println("Constructor without arguments");
        Example5 constructorWithoutArguments = new Example5();
        System.out.println(constructorWithoutArguments);

        System.out.println("Constructor with arguments");
        Example5 constructorWithArguments = new Example5(999);
        System.out.println(constructorWithArguments);

        System.out.println("Method with arguments");
        Example5 methodWithArguments = new Example5();
        methodWithArguments.setInteger(87007);
        System.out.println(methodWithArguments);

        System.out.println("Method without arguments");
        Example5 methodWithoutArguments = new Example5(87687686);
        methodWithoutArguments.setInteger();
        System.out.println(methodWithoutArguments);

    }

    Example5 () {
        this.integer = 0;
    }
    Example5 (int input) {
        this.integer = input;
    }

    public void setInteger(int input) {
        this.integer = Math.min(input, 100);
    }

    public void setInteger() {
        this.integer = 0;
    }
    public int getInteger() {
        return integer;
    }

    public String toString() {
        return "" + this.integer;
    }

}
