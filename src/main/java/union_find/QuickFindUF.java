package union_find;

import java.util.Arrays;

/**
 * COST MODEL:
 * initialize - N
 * union - N
 * find - 1
 * worst-case time - MxN
 */

public class QuickFindUF extends UF{

    protected int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
