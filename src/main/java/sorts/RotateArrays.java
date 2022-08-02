package sorts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RotateArrays {
    private int[] arrayOne;
    private int[] arrayTwo;
    private int size;

    public RotateArrays(int size) {
        this.size = size;
        this.arrayOne = new int[size];
        this.arrayTwo = new int[size];

        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arrayOne[i] = rnd.nextInt(3);
            arrayTwo[i] = rnd.nextInt(3);
        }
    }

    private boolean checkTheSame(){
        Map<Integer, Integer> mapFirst = new HashMap<>();
        Map<Integer, Integer> mapSecond = new HashMap<>();

        for (int i = 0; i < size; i++) {
            mapFirst.merge(arrayOne[i], 1, Integer::sum);
            mapSecond.merge(arrayTwo[i], 1, Integer::sum);
        }
        System.out.println(mapFirst);
        System.out.println(mapSecond);

        return mapFirst.equals(mapSecond);
    }

    public static void main(String[] args) {
        RotateArrays values = new RotateArrays(5);
        System.out.println(values);
        System.out.println(values.checkTheSame());
    }

    @Override
    public String toString() {
        return "Arrays{" +
                "arrayOne=" + Arrays.toString(arrayOne) +
                ", arrayTwo=" + Arrays.toString(arrayTwo) +
                '}';
    }
}
