package quick_sort;

import java.util.Arrays;

public class DecimalDominants {

    public static void main(String[] args) {

        int[] array = new int[]{1, 7, 3 , 5, 4, 9, 3, 4, 8, 6, 11, 10};


        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int minCount = 1 + array.length /10;
        System.out.printf("Size = %d; minK = %d\n", array.length, minCount);
        int dominants = 0;
        int count = 1;
        int val = array[0];
        for (int i = 1; i < array.length-minCount; i++) {
            if (array[i] == val) {
                count++;
            } else {
                if (count>=minCount) dominants++;
                count = 1;
                val = array[i];
            }
        }
        System.out.println("Dominants = " + dominants);

    }

}
