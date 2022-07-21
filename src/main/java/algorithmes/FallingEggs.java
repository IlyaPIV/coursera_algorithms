package algorithmes;

public class FallingEggs {
    private static int n;
    private static int t;
    private static int eggs;

    public static void main(String[] args) {
        versionOne(10, 3);
    }

    private static void versionOne(int n, int t){
        FallingEggs.t = t;
        FallingEggs.eggs = 1;
        FallingEggs.n = n;

        for (int i = 1; i <= n; i++) {
            if (eggIsBroken(i)) {
                System.out.println("result = " + i);
                break;
            }
        }
    }

    private static boolean eggIsBroken(int level) {
        if (level<t) return false;
            else {
                eggs--;
                return true;
        }
    }
}
