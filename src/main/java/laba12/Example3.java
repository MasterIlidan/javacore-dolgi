package laba12;

public class Example3 {
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            Thread.currentThread().setName("evenThread");
            synchronized (lock) {
                while (num <= 10) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            Thread.currentThread().setName("oddThread");
            synchronized (lock) {
                while (num <= 10) {
                    if (num % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        });
        oddThread.start();
        evenThread.start();
    }
}
