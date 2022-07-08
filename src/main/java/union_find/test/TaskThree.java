package union_find.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskThree {
    private static List<Integer> S;

    public static void main(String[] args) {
        int size = 100;
        initS(size);
        System.out.println("========INIT=======");
        System.out.println(S);
        System.out.println("===================");

        int[] arrayDeleting = {5, 7, 9, 13, 6, 20, 95, 11, 50, 51, 60, 12, 94, 99, 1, 0};

        for (int del:
             arrayDeleting) {
            makeIteration(del);
        }
    }

    private static void makeIteration(int del) {
        int iter = 0;
        System.out.println("X = " + del);
        int start = 0;
        int end = S.size()-1;
        while (true) {
            iter++;
            int pos = start + (end - start)/2;
            int value = S.get(pos);
            System.out.printf("iteration #%d - S[%d]=%d\n", iter, pos, value);
            if (value == del) {
                doWhenFind(pos);
                break;
            }
            if (value > del) {
                end = pos;
                if ((end-start)==1) {
                    doWhenFind(start);
                    break;
                }
            } else {
                start = pos;
                if ((end-start)==1) {
                    doWhenFind(end);
                    break;
                }
            }

        }
        System.out.println("===================");
    }

    private static void initS(int size){
        S = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            S.add(i);
        }
    }

    private static void doWhenFind(int pos) {
        if (pos == S.size()-1) System.out.println("Y is unreachable!");
        else System.out.println("Y = "+S.get(pos+1));
        S.remove(pos);
    }
}
