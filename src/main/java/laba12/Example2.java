 package laba12;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread.currentThread().setName("1-10 thread");
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread name: " + Thread.currentThread().getName() + ", number: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
        thread.join();
    }
}
