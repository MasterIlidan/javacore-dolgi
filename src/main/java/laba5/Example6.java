package laba5;

public class Example6 {
    /*Напишите программу с классом, в котором есть два закрытых
целочисленных поля (назовем их max и min). Значение поля max не может
быть меньше значения поля min. Значения полям присваиваются с помощью
открытого метода. Метод может вызываться с одним или двумя
целочисленными аргументами. При вызове метода значения полям
присваиваются так: сравниваются текущие значения полей и значения
аргументов, переданных методу. Самое большое из значений присваивается
полю max, а самое маленькое из значений присваивается полю min.
Предусмотрите конструктор, который работает по тому же принципу, что и
метод для присваивания значений полям. В классе также должен быть метод,
отображающий в консольном окне значения полей объекта.*/
    private int max;
    private int min;
    
    public static void main(String[] args) {

        System.out.println("Constructor with one argument");
        Example6 constructorWithOneArguments = new Example6(999);
        constructorWithOneArguments.printAll();

        System.out.println("Constructor with two arguments");
        Example6 constructorWithTwoArguments = new Example6(999,777);
        constructorWithTwoArguments.printAll();

        System.out.println("Method with one argument");
        Example6 methodWithOneArgument = new Example6(0);
        methodWithOneArgument.setNewValue(87007);
        methodWithOneArgument.printAll();

        System.out.println("Method with two arguments");
        Example6 methodWithoutArguments = new Example6(0);
        methodWithoutArguments.setMinAndMax(121,9999);
        methodWithoutArguments.printAll();
    }
    
    Example6(int input1, int input2){
        min = Math.min(input1, input2);
        max = Math.max(input1, input2);
    }

    Example6(int input){
        min = Math.min(input, 0);
        max = Math.max(input, 0);
    }
    
    public  void setMinAndMax(int input1, int input2) {
        min = Math.min(input1, input2);
        max = Math.max(input1, input2);
    }
    
    public  void setNewValue(int input) {
        min = Math.min(input, min);
        max = Math.max(input, max);
    }
    
    public void printAll() {
        System.out.println("Max: " + max +
                "\nMin: " + min);
    }
}
