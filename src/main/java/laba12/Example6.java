package laba12;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Example6 {
    public static void main(String[] args) {
        int[] array = getInitArray(10000);
        ArraySummarizer arraySummarizer = new ArraySummarizer(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int sum = forkJoinPool.invoke(arraySummarizer);
        System.out.println(sum);
    }

    private static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
}

class ArraySummarizer extends RecursiveTask<Integer> {
    private int[] array;

    ArraySummarizer(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 1000) {
            System.out.println(Thread.currentThread().getName());
            return Arrays.stream(array).sum();
        }
        ArraySummarizer firstHalf = new ArraySummarizer(Arrays.copyOfRange(array, 0, array.length / 2));
        firstHalf.fork();
        ArraySummarizer secondHalf = new ArraySummarizer(Arrays.copyOfRange(array, array.length / 2, array.length));
        secondHalf.fork();

        return firstHalf.join() + secondHalf.join();
    }
}