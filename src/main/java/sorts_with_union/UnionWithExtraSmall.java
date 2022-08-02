package sorts_with_union;

import java.util.Arrays;

public class UnionWithExtraSmall {

    private int[] array;
    private int size;
    private int pointN;
    private int[] extra;

    public UnionWithExtraSmall(int pointN) {
        this.pointN = pointN;
        this.size = 2 * pointN;
        this.array = new int[this.size];
        this.extra = new int[pointN];
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void union(){
        int pointMain = pointN;
        int pointExtra = 0;
        int pointInsert = 0;
        System.out.println("start:");
        for (int i = 0; i < pointN; i++) {
            extra[i] = array[i];
            array[i] = Integer.MIN_VALUE;
        }

        int iter = 0;
        while (pointExtra<pointN) {
            iter++;
            System.out.println("=========== #" + iter + "===========");
            if (array[pointMain] < extra[pointExtra]) {
                array[pointInsert] = array[pointMain];
                array[pointMain] = Integer.MIN_VALUE;
                pointMain++;
            } else {
                array[pointInsert] = extra[pointExtra];
                pointExtra++;
            }
            pointInsert++;
            System.out.println("Insert point = " + pointInsert);
            System.out.println("Main (" + pointMain+ ")" + Arrays.toString(array));
            System.out.println("Extra (" + pointExtra + ")" + Arrays.toString(extra));
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        UnionWithExtraSmall task = new UnionWithExtraSmall(9);
        task.setArray(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 2, 4, 6, 8, 10, 12, 14, 16, 18});
        task.union();
        System.out.println("========== RESULT ==========");
        System.out.println(task.toString());
    }
}
