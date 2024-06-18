package laba9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class Compare {
    static final long countOfElements = 10 * 1000000;
    static final long countOfElementsForIndexSearch = 10L * 1000000000;

    public static void main(String[] args) {
        /*HashSet<Integer> hashSet;
        LinkedHashSet<Integer> linkedHashSet;*/
        ArrayListCompare arrayListCompare = new ArrayListCompare(countOfElements);

        arrayListCompare.getAddToStartExecuteTime();
        arrayListCompare.getAddToEndExecuteTime();
        arrayListCompare.getAddToMiddleExecuteTime();
        arrayListCompare.getRemoveFromStartExecuteTime();
        arrayListCompare.getRemoveFromEndExecuteTime();
        arrayListCompare.getRemoveFromMiddleExecuteTime();

        arrayListCompare = new ArrayListCompare(countOfElementsForIndexSearch);
        arrayListCompare.getRandomAccessExecuteTime();
    }


}

class ArrayListCompare {
    ArrayList<Integer> arrayList;

    ArrayListCompare(long size) {
        if (size > Integer.MAX_VALUE) {
            arrayList = LongArrayList(Integer.MAX_VALUE-10);
        } else {
            arrayList = LongArrayList((int) size);
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

    public void getAddToStartExecuteTime() {
        System.out.println("Adding item to start...");
        long startTime = System.currentTimeMillis();
        arrayList.add(1, (int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    public void getAddToEndExecuteTime() {
        System.out.println("Adding item to end...");
        long startTime = System.currentTimeMillis();
        arrayList.add((int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    public void getAddToMiddleExecuteTime() {
        System.out.println("Adding item to middle...");
        long startTime = System.currentTimeMillis();
        arrayList.add(arrayList.size() / 2, (int) startTime);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    public void getRemoveFromStartExecuteTime() {
        System.out.println("Removing item from start...");
        long startTime = System.currentTimeMillis();
        arrayList.remove(1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    public void getRemoveFromEndExecuteTime() {
        System.out.println("Removing item from end...");
        long startTime = System.currentTimeMillis();
        arrayList.remove(arrayList.size() - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    public void getRemoveFromMiddleExecuteTime() {
        System.out.println("Removing item from middle...");
        long startTime = System.currentTimeMillis();
        arrayList.remove(arrayList.size() / 2);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    public void getRandomAccessExecuteTime() {
        int index = new Random().nextInt(arrayList.size() - 1);
        System.out.println("Getting random access time for index: " + index);
        long startTime = System.currentTimeMillis();
        long value = arrayList.get(index);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " value is " + value);


    }
}