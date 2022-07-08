package union_find;

public abstract class UF {

    //initialize union-find data structure with N objects (0 to N-1)
//    public UF(int n) {
//    }

    //add connection between p and q
    public abstract void union(int p, int q);

    //are p and q in the same component?
    public abstract boolean connected(int p, int q);

    @Override
    public abstract String toString();
}
