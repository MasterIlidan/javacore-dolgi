package laba13;

public class Example12 {
    public static void m(String string, double number) {
        if (string == null) {
            throw new IllegalArgumentException("Incorrect string");
        }
        if (number > 0.001) {
            throw new IllegalArgumentException("Incorrect number");
        }
    }

    public static void main(String[] args) {
        m(null, 0.0000001);
    }
}
