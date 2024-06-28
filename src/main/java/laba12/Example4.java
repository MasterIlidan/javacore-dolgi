package laba12;

public class Example4 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                Thread.currentThread().setName("Thread " + finalI);
                System.out.println("Hi! I am " + Thread.currentThread().getName());
            }).start();
        }
    }

}
