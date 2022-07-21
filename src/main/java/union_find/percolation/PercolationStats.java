package union_find.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double mean;
    private final double stddev;
    private final double confidenceHi;
    private final double confidenceLo;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n<=0 || trials<=0) throw new IllegalArgumentException("Value is <= 0");

        double[] treshold = new double[trials];

        for (int i = 0; i < trials; i++) {
            //System.out.println(">>> i = " + (i+1));
            Percolation percolation = new Percolation(n);
            int opened = 0;
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    opened++;
                }
            }
            treshold[i] = (double) opened / (n * n);
        }

        this.stddev = StdStats.stddev(treshold);
        this.mean = StdStats.mean(treshold);
        double delta = 1.96 * stddev / Math.sqrt(trials);
        this.confidenceLo = mean - delta;
        this.confidenceHi = mean + delta;
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args){
        PercolationStats ps = new PercolationStats(200, 100);
        System.out.println("Mean            = " + ps.mean());
        System.out.println("StdDev          = " + ps.stddev());
        System.out.println("95% interval    = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
