package algorithmes;

/*
* Поиск в битоническом массиве. Массив называется битоническим, если он состоит из возрастающей последовательности целых значений,
* сразу за которой следует убывающая последовательность целых чисел. Напишите программу, которая бы проверяла заданное целое значение
* на вхождение в битонический массив из n уникальных целых значений.
*        Стандартная версия: используйте ~3*lg n сравнений в худшем случае.
*        Бонус при приеме на работу: используйте ∼2*lg n сравнений в худшем случае (и докажите, что ни один алгоритм не сможет
*           гарантировать выполнение менее ∼2*lg n сравнений в худшем случае).
*/

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int[] array = { 1, 2, 4, 5, 7, 9, 11, 15, 17, 12, 10, 8};
        System.out.println(Arrays.toString(array));
        int middle = findArrayMiddle(array, 0, array.length - 1);
        System.out.println("peak = array[" + middle + "]");

        int searching = 0;
        searching = 12;
        System.out.println(searching + " = " + findInArray(array, middle, searching));
        searching = 13;
        System.out.println(searching + " = " + findInArray(array, middle, searching));
        searching = 7;
        System.out.println(searching + " = " + findInArray(array, middle, searching));

    }

    private static int findArrayMiddle(int array[], int begin, int end) {
        int point = (begin + end) / 2;
        if (begin == end) return point;

        if (array[point] < array[point+1]) {
            return findArrayMiddle(array, point+1, end);
        } else {
            return findArrayMiddle(array, begin, point);
        }
    }

    private static boolean findInArray(int array[], int peak, int searching) {

        return searchInArrayRise(array, 0, peak, searching) || searchInArrayDesc(array, peak, array.length-1, searching);
    }

    private static boolean searchInArrayRise(int[] array, int start, int end, int searching) {
        int point = (start + end) / 2;
        if (array[point] == searching) return true;

        if (start > end) return false;

        if (array[point] > searching) return searchInArrayRise(array, start, point-1, searching);
            else return searchInArrayRise(array, point+1, end, searching);
    }

    private static boolean searchInArrayDesc(int[] array, int start, int end, int searching) {
        int point = (start + end) / 2;
        if (array[point] == searching) return true;

        if (start > end) return false;

        if (array[point] < searching) return searchInArrayDesc(array, start, point-1, searching);
            else return searchInArrayDesc(array, point+1, end, searching);
    }


}
