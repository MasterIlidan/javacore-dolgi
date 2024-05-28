package laba9;
/*3 Создать приложение, позволяющее ввести и вывести одномерный
массив целых чисел. Для ввода и вывода массива разработать рекурсивные
методы вместо циклов for.*/
public class Example8 {
    public static void main(String[] args) {
        int[] array = new int[10];
        array = fillArray(array,0);
        //System.out.println(Arrays.toString(array));
        System.out.println(printArray(array, 0));
    }
    public static int[] fillArray(int[] array, int startIndex) {
        if (startIndex >= array.length) return array;
        array[startIndex] = startIndex;
        return fillArray(array, startIndex + 1);
    }
    public static StringBuilder printArray(int[] array, int startIndex) {
        if (startIndex >= array.length) return new StringBuilder();
        return new StringBuilder().append(array[startIndex] + ", ").append(printArray(array, startIndex + 1));
    }


}
