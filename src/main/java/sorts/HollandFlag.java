package sorts;

import java.util.Arrays;
import java.util.Random;

public class HollandFlag {

    private int[] baskets;


    public HollandFlag(int size) {
        this.baskets = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            baskets[i] = rnd.nextInt(3);
        }
        System.out.println("start baskets: " + Arrays.toString(baskets));
    }

    public void sortBaskets(){
        int loPoint = 0;
        int midPoint = 0;
        int hiPoint = baskets.length-1;

        for (int i = 0; i < baskets.length; i++) {
            while (midPoint <= hiPoint) {
                if (baskets[midPoint] == 0) {
                    swap(midPoint, loPoint);
                    midPoint++;
                    loPoint++;
                } else if (baskets[midPoint] == 2) {
                    swap(midPoint, hiPoint);
                    hiPoint--;
                } else midPoint++;

            }
        }
        System.out.println("sort result: " + Arrays.toString(baskets));
    }

    private void swap(int point1, int point2) {
        int temp = baskets[point2];
        baskets[point2] = baskets[point1];
        baskets[point1] = temp;
    }

    public static void main(String[] args) {
        HollandFlag colors = new HollandFlag(10);
        colors.sortBaskets();
    }
}
