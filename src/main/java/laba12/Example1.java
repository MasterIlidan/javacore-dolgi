package laba12;

import java.time.LocalTime;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread.currentThread().setName("Timer thread");
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread name: " + Thread.currentThread().getName() + ", current time " + LocalTime.now());
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
