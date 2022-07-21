package union_find.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {

    private final boolean[][] field;
    private final int size;
    private int openCount;
    private final WeightedQuickUnionUF uf;
    private final int virtualTop;
    private final int virtualBottom;



    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n<=0) throw new IllegalArgumentException();

        this.uf = new WeightedQuickUnionUF(n*n + 2);
        this.openCount = 0;
        this.field = new boolean[n][n];
        this.size = n;
        this.virtualTop = 0;
        this.virtualBottom = n*n + 1;
//        for (int i = 0; i < size; i++) {
//            uf.union(virtualTop, i+1);
//            uf.union(size*(size-1)+i+1, virtualBottom);
//        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException{
        if (row <=0 || row > size || col <=0 || col > size) {
            throw new IllegalArgumentException();
        } else {
            if (!isOpen(row, col)) {
                field[row-1][col-1] = true;
                openCount++;
                int openedIndex = size * (row-1) + col;

                if (row == 1) uf.union(virtualTop, openedIndex);
                if (row == size) uf.union(openedIndex, virtualBottom);

                tryConnect(row - 1, col, openedIndex); //with top
                tryConnect(row, col - 1, openedIndex); //with left
                tryConnect(row, col + 1, openedIndex); //with right
                tryConnect(row + 1, col, openedIndex); //with bottom
            }
        }
    }

    private void tryConnect(int row, int col, int openedIndex){
        if (row <=0 || row > size || col <=0 || col > size) return;
        if (isOpen(row, col)) {
            int neighborIndex = size * (row - 1) + col;
            uf.union(openedIndex, neighborIndex);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException{
        if (row <=0 || row > size || col <=0 || col > size) {
            throw new IllegalArgumentException();
        } else {
            return field[row-1][col-1];
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) throws IllegalArgumentException{
        if (row <=0 || row > size || col <=0 || col > size) {
            throw new IllegalArgumentException();
        } else {
            int index = size * (row-1) + col;
            return uf.find(index) == uf.find(virtualTop);
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualTop)==uf.find(virtualBottom);
    }

    public void showField(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                StdOut.printf("\t%s", field[i][j] ? "*" : "-");
            }
            StdOut.println();
        }
    }

    // test client (optional)
    public static void main(String[] args) {
      testOne();

      testTwo();
    }

    public static void testOne(){
        Percolation testPercolate = new Percolation(5);
        //iteration #1
        testPercolate.open(1,3);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #2
        testPercolate.open(1,4);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #3
        testPercolate.open(5,1);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #4
        testPercolate.open(4,2);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #5
        testPercolate.open(3,3);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #6
        testPercolate.open(2,4);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #7
        testPercolate.open(5,2);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #8
        testPercolate.open(5,5);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #9
        testPercolate.open(3,2);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #10
        testPercolate.open(3,4);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
    }

    public static void testTwo(){
        Percolation testPercolate = new Percolation(4);
        //iteration #1
        testPercolate.open(4,2);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #2
        testPercolate.open(1,1);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #3
        testPercolate.open(3,4);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #4
        testPercolate.open(3,2);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #5
        testPercolate.open(2,3);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #6
        testPercolate.open(1,3);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #7
        testPercolate.open(1,2);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #8
        testPercolate.open(4,4);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #9
        testPercolate.open(4,1);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
        //iteration #10
        testPercolate.open(2,4);
        testPercolate.showField();
        StdOut.println("percolates = " + testPercolate.percolates());
    }
}
