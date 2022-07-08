package union_find;


/**
 * COST MODEL:
 * initialize - N
 * union - lg N (*incl cost of finding roots)
 * find - lg N
 * worst-case time - N + M x logN  (weighted QU)
 * worst-case time - N + M x logN  (QU + path compression)
 * worst-case time - N + M x lgN  (weighted QU + path compression)
 */
public class WeightedQuickUnionUF extends QuickUnionUF{
    
    protected int[] sz;
    
    public WeightedQuickUnionUF(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    @Override
    protected int root(int i) {

        while (i != id[i]) {
            //**simpler one-pass variant path compression
            id[i] = id[id[i]];
            //**end

            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
