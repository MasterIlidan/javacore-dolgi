package laba5;

public class Example3 {
    /*Напишите программу с классом, у которого есть два целочисленных поля.
В классе должны быть описаны конструкторы, позволяющие создавать
объекты без передачи аргументов, с передачей одного аргумента и с
передачей двух аргументов.*/
    
    int integer1;
    int integer2;
    
    public static void main(String[] args) {
        Example3 withoutArguments = new Example3();
        System.out.println(withoutArguments);
        
        Example3 withOneArgument = new Example3(999);
        System.out.println(withOneArgument);

        Example3 withArguments = new Example3(222,333);
        System.out.println(withArguments);
    }
    Example3() {
        integer1 = 10;
        integer2 = 20;
    }
    
    Example3(int integer1, int integer2) {
        this.integer1 = integer1;
        this.integer2 = integer2;
    }
    
    Example3(int integer1) {
        this.integer1 = integer1;
        this.integer2 = integer1;
    }
    @Override
    public String toString() {
        return integer1 + "," + integer2;
    }
    
}
