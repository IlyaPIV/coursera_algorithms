package union_find;

import union_find.test.TaskTwo;

import java.io.*;
import java.util.Arrays;

public class Client {

    private static final BufferedReader stdIn;

    static {
        try {
            stdIn = new BufferedReader(new FileReader("src/main/resources/union_find/tinyUF.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        try {
            int n = Integer.parseInt(stdIn.readLine());
            //uf = new QuickFindUF(n);
            //UF uf = new QuickUnionUF(n);

            TaskTwo uf = new TaskTwo(n);


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
            System.out.println("===========");
            System.out.println("MAX for 2 = " + uf.find(2));
            System.out.println("MAX for 3 = " + uf.find(3));
            System.out.println("MAX for 4 = "+uf.find(4));
            System.out.println("MAX for 8 = "+uf.find(8));
            System.out.println("MAX for 0 = "+uf.find(0));
            System.out.println("MAX for 6 = "+uf.find(2));
            System.out.println("MAX for 5 = "+uf.find(5));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
