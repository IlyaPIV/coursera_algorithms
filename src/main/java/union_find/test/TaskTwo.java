package union_find.test;


import java.util.Arrays;

public class TaskTwo{

    protected int[] id;

    public TaskTwo(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    protected int root(int i) {
        while (i != id[i]) {

            id[i] = id[id[i]];

            i = id[i];
        }
        return i;
    }


    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i==j) return;
        if (id[i] > id[j]) {
            id[j] = i;
        } else {
            id[i] = j;
        }
    }

    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }

    public int find(int x) {
        int max = id[x];
        while (max != id[max]) {
            max = id[max];
        }
        return max;
    }
}
