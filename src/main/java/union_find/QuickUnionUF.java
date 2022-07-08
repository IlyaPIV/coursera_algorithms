package union_find;


/**
 * COST MODEL:
 * initialize - N
 * union - N (*incl cost of finding roots)
 * find - N
 * worst-case time - MxN
 */
public class QuickUnionUF extends QuickFindUF{

    public QuickUnionUF(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    protected int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
