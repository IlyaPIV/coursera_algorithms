package union_find;

import java.io.*;
import java.util.Arrays;

public class Client {

    private static final BufferedReader stdIn;

    static {
        try {
            stdIn = new BufferedReader(new FileReader("C:\\Users\\ipetrushin\\IdeaProjects\\coursera_algorithms\\src\\main\\resources\\union_find\\tinyUF.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        try {
            int n = Integer.parseInt(stdIn.readLine());
            //uf = new QuickFindUF(n);
            UF uf = new QuickUnionUF(n);


            System.out.println(n);
            while (stdIn.ready()) {
                String[] lineVals = stdIn.readLine().split(" ");
                int p = Integer.parseInt(lineVals[0]);
                int q = Integer.parseInt(lineVals[1]);
                if (uf.connected(p, q)) {
                    System.out.printf("%d - %d\n", p , q);
                } else {
                    System.out.printf("%d\t%d\n", p , q);
                    uf.union(p, q);
                }
            }
            System.out.println(uf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
