package sorts;

import java.util.*;

public class TwoArrays {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x +
                    "; " + y +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static Point[] first;
    static Point[] second;

    public static void main(String[] args) {
        Random rnd = new Random();
        TwoArrays.first = new Point[10];
        for (int i = 0; i < first.length; i++) {
            first[i] = new Point(rnd.nextInt(10) - 5, rnd.nextInt(10) - 5);
        }
        TwoArrays.second = new Point[7];
        for (int i = 0; i < second.length; i++) {
            second[i] = new Point(rnd.nextInt(10) - 5, rnd.nextInt(10) - 5);
        }
        System.out.println("First array = " + Arrays.toString(first));
        System.out.println("Second array = " + Arrays.toString(second));

        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < first.length; i++) {
            map.put(first[i], 1);
        }
        for (int i = 0; i < second.length; i++) {
            map.merge(second[i], 1, Integer::sum);
        }
        System.out.println("Values: " + map);
        System.out.println("Union: " + map.entrySet().stream().filter(entry -> entry.getValue()==2).toList());
    }
}
