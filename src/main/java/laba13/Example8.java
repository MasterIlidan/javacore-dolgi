package laba13;

public class Example8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
        int someInt = m();
        for (int i = 0; i < someInt; i++) {
            System.out.println("Hello");
        }
    }
}
