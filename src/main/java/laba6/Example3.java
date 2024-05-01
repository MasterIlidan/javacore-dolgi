package laba6;

public class Example3 {
    /*Напишите программу с классом, в котором есть статические методы, которым
можно передавать произвольное количество целочисленных аргументов (или
целочисленный массив). Методы, на основании переданных аргументов или массива,
позволяют вычислить: наибольшее значение, наименьшее значение, а также среднее
значение из набора чисел.*/
    public static void main(String[] args) {
        System.out.println("Max from num sequence 5676,5123,78236,234236 is: " + getMaxFromSequence(5676,5123,78236,234236));

        int[] nums = {45,2167889,225,634577547,1254};
        System.out.println("Min from array {45,2167889,225,634577547,1254} is: " + getMinFromSequence(nums));

        System.out.println("Avg from array {45,2167889,225,634577547,1254} is: " + getAvgFromSequence(nums));
    }

    public static int getMaxFromSequence(int... nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    public static int getMinFromSequence(int... nums) {
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
    public static double getAvgFromSequence(int... nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return (double) sum / nums.length;
    }
}
