package laba13;

public class Example13 {
    public static void main(String[] args) {
        try {
            int length = args.length;
            System.out.println("args length = " + length);
            int h = 10/length;
            args[length + h] = "10";
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index don't exist");
        }
    }
}
