package laba9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Compare {
    static final long countOfElements = 10 * 1000000;
    static final long countOfElementsForIndexSearch = 10L * 1000000000;

    public static void main(String[] args) {
        /*HashSet<Integer> hashSet;
        LinkedHashSet<Integer> linkedHashSet;*/

    }

    private static void ArrayListCompare() {
        ArrayListCompare arrayListCompare = new ArrayListCompare(countOfElements);

        arrayListCompare.getAddToStartExecuteTime();
        arrayListCompare.getAddToEndExecuteTime();
        arrayListCompare.getAddToMiddleExecuteTime();
        arrayListCompare.getRemoveFromStartExecuteTime();
        arrayListCompare.getRemoveFromEndExecuteTime();
        arrayListCompare.getRemoveFromMiddleExecuteTime();

        try {
            arrayListCompare = new ArrayListCompare(countOfElementsForIndexSearch);
            arrayListCompare.getRandomAccessExecuteTime();
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError. Skipping...");
        }
    }

    private static void HashSetCompare() {

    }


}

abstract class Comparing<T> {
    T compareInstance;

    abstract void getAddToStartExecuteTime();

    abstract void getAddToEndExecuteTime();

    abstract void getAddToMiddleExecuteTime();

    abstract void getRemoveFromStartExecuteTime();

    abstract void getRemoveFromEndExecuteTime();

    abstract void getRemoveFromMiddleExecuteTime();

    abstract void getRandomAccessExecuteTime();
}


class ArrayListCompare extends Comparing<ArrayList<Integer>> {
    //ArrayList<Integer> compareInstance;

    ArrayListCompare(long size) {
        if (size > Integer.MAX_VALUE) {
            compareInstance = LongArrayList(Integer.MAX_VALUE - 10);
        } else {
            compareInstance = LongArrayList((int) size);
        }
    }

    private ArrayList<Integer> LongArrayList(int countOfElements) {
        System.out.println("Creating ArrayList with " + countOfElements + " elements");
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>(countOfElements);
        for (int i = 0; i < countOfElements; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
        return arrayList;
    }

    @Override
    public void getAddToStartExecuteTime() {
        System.out.println("Adding item to start...");
        long startTime = System.currentTimeMillis();
        compareInstance.add(1, (int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getAddToEndExecuteTime() {
        System.out.println("Adding item to end...");
        long startTime = System.currentTimeMillis();
        compareInstance.add((int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getAddToMiddleExecuteTime() {
        System.out.println("Adding item to middle...");
        long startTime = System.currentTimeMillis();
        compareInstance.add(compareInstance.size() / 2, (int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRemoveFromStartExecuteTime() {
        System.out.println("Removing item from start...");
        long startTime = System.currentTimeMillis();
        compareInstance.remove(1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRemoveFromEndExecuteTime() {
        System.out.println("Removing item from end...");
        long startTime = System.currentTimeMillis();
        compareInstance.remove(compareInstance.size() - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRemoveFromMiddleExecuteTime() {
        System.out.println("Removing item from middle...");
        long startTime = System.currentTimeMillis();
        compareInstance.remove(compareInstance.size() / 2);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRandomAccessExecuteTime() {
        int index = new Random().nextInt(compareInstance.size() - 1);
        System.out.println("Getting random access time for index: " + index);
        long startTime = System.currentTimeMillis();
        long value = compareInstance.get(index);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " value is " + value);
    }
}

class HashSetCompare extends Comparing<HashSet<Integer>> {

    HashSetCompare(long size) {
        if (size > Integer.MAX_VALUE) {
            compareInstance = LongHashSet(Integer.MAX_VALUE - 10);
        } else {
            compareInstance = LongHashSet((int) size);
        }
    }

    private HashSet<Integer> LongHashSet(int countOfElements) {
        System.out.println("Creating HashSet with " + countOfElements + " elements");
        long startTime = System.currentTimeMillis();
        HashSet<Integer> hashSet = new HashSet<>(countOfElements);
        for (int i = 0; i < countOfElements; i++) {
            hashSet.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
        return hashSet;
    }

    @Override
    public void getAddToStartExecuteTime() {
        System.out.println("Adding item to start...");
        long startTime = System.currentTimeMillis();
        compareInstance.add((int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getAddToEndExecuteTime() {
        System.out.println("HashSet is unordered");
    }

    @Override
    public void getAddToMiddleExecuteTime() {
        System.out.println("HashSet is unordered");
    }

    @Override
    public void getRemoveFromStartExecuteTime() {
        System.out.println("Removing item from start...");
        long startTime = System.currentTimeMillis();
        compareInstance.remove(1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRemoveFromEndExecuteTime() {
        System.out.println("Removing item from end...");
        long startTime = System.currentTimeMillis();
        compareInstance.remove(compareInstance.size() - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRemoveFromMiddleExecuteTime() {
        System.out.println("Removing item from middle...");
        long startTime = System.currentTimeMillis();
        compareInstance.remove(compareInstance.size() / 2);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    @Override
    public void getRandomAccessExecuteTime() {
        int index = new Random().nextInt(compareInstance.size() - 1);
        System.out.println("Getting random access time for index: " + index);
        long startTime = System.currentTimeMillis();
        boolean value = compareInstance.contains(index);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " value is " + value);
    }
}