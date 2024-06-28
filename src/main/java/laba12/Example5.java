package laba12;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Example5 {
    public static void main(String[] args) throws InterruptedException {
        int[] array = getInitArray(999999);
        MaxValueSearcher maxValueSearcher = new MaxValueSearcher(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int maxFromSearcher = forkJoinPool.invoke(maxValueSearcher);
        System.out.println(maxFromSearcher);

        /*int maxFromTraditional = Arrays.stream(array).max().getAsInt();

        assert maxFromTraditional == maxFromSearcher;*/

    }

    private static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}

class MaxValueSearcher extends RecursiveTask<Integer> {

    private int[] array;

    MaxValueSearcher(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length < 10000) {
            return Arrays.stream(array).max().getAsInt();
        }
        MaxValueSearcher firstHalf = new MaxValueSearcher(Arrays.copyOfRange(array, 0, array.length / 2));
        firstHalf.fork();
        MaxValueSearcher secondHalf = new MaxValueSearcher(Arrays.copyOfRange(array, array.length / 2, array.length));
        secondHalf.fork();

        return Math.max(firstHalf.join(), secondHalf.join());
    }
}
