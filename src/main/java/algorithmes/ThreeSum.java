package algorithmes;

import java.util.Arrays;

/*
* 3-SUM за квадратичное время. Составьте алгоритм для решения задачи 3-SUM за время, пропорциональное n^2, в худшем случае.
* Можно принять, что вы можете отсортировать nn целых чисел за время, пропорциональное n^2, или лучше.
 */

public class ThreeSum {

    public static int findThreeNumbers(int array[], int sum){
        int length = array.length;
        int count = 0;
        if (length < 3) return 0;
        Arrays.sort(array);
        int iteration = 0;
        for (int i = 0; i < length - 2; i++) {
            System.out.println("#" + i + ": " + Arrays.toString(array));
            iteration++;
            int startPoz = i + 1;
            int endPoz = length - 1;


            while (startPoz != endPoz) {
                iteration++;
                System.out.printf("#%d:\t%d + %d + %d = ", iteration, array[i], array[startPoz], array[endPoz]);
                if ((array[startPoz] + array[endPoz]) < -array[i]) {
                    startPoz++;
                    System.out.println("false (startPoz >>)");
                } else if ((array[startPoz] + array[endPoz]) > -array[i]) {
                    endPoz--;
                    System.out.println("false (endPoz <<)");
                } else {
                    count++;
                    System.out.println("true!!! (Count +1)");
                    break;
                }

            }

        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("result = " + findThreeNumbers(new int[]{30, -40, -20, -10, 40, 0, 10, 5},0));
    }
}
