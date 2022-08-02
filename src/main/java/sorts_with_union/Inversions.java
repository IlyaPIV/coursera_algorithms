package sorts_with_union;

import java.util.Arrays;

public class Inversions {
    private int[] array;

    public Inversions() {
        this.array = new int[]{1, 3, 5, 2, 4, 6};
        //this.array = new int[]{1, 8, 4, 5, 2, 3, -3, 6, 4, 10, 9};
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void countInversions(){
        int inv = count(array);

        System.out.println("Inversions total = " + inv);
    }

    private int count(int[] arr) {
      if (arr.length < 2) return 0;

      int mid = (arr.length + 1) / 2;
      int[] left = Arrays.copyOfRange(arr, 0, mid);
      int[] right = Arrays.copyOfRange(arr, mid, arr.length);

      int countLeft = count(left);
      int countRight = count(right);
      int countMerge = merge(arr, left, right);

      return countLeft + countRight + countMerge;
    }

    private int merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i< left.length || j< right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length - i;
                j++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Inversions data = new Inversions();
        System.out.println(data);
        data.countInversions();

    }

}
