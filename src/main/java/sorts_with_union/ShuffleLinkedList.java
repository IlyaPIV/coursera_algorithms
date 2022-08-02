package sorts_with_union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ShuffleLinkedList {
    // Общий метод рандомизации списка в Java с использованием перетасовки Фишера-Йейтса
    public static<T> void shuffle(List<T> list)
    {
        Random random = new Random();
        int n = list.size();

        // начинаем с начала списка
        for (int i = 0; i < n - 1; i++)
        {
            // получить случайный индекс `j` такой, что `i <= j <= n`
            int j = i + random.nextInt(n - i);

            // поменять местами элемент в i-й позиции в списке с элементом в
            // случайно сгенерированный индекс `j`
            T obj = list.get(i);
            list.set(i, list.get(j));
            list.set(j, obj);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        shuffle(list);

        System.out.println(list);
    }
}