import java.util.Scanner;

public class Loki {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("N: ");
        int N = input.nextInt();
        String[] items = new String[N];
        for (int i = 0; i < N; i++) {
            items[i] = input.next();
        }
        System.out.print("Q: ");
        int Q = input.nextInt();
        for (int q = 0; q < Q; q++) {
            System.out.print("K L: ");
            int K = input.nextInt();
            String L = input.next();
            int[] swap = new int[N];
            for (int i = 0; i < N; i++) {
                swap[i] = i;
            }
            for (int k = 0; k < K; k++) {
                System.out.print("a -> b: ");
                int a = input.nextInt() - 1;
                int b = input.nextInt() - 1;
                swap[a] = b;
            }
            long Lnum = parseL(L);
            String[] result = applyMantra(items, swap, Lnum);
            printResult(result);
        }
    }

    // parse the L string into a long number
    public static long parseL(String L) {
        if (L.contains("e")) {
            String[] parts = L.split("e");
            long P = Long.parseLong(parts[1]);
            long Q = Long.parseLong(parts[2]);
            return (long) Math.pow(10, P) + Q;
        } else {
            return Long.parseLong(L);
        }
    }

    // apply the mantra to the items array, using the swap array, for Lnum times
    public static String[] applyMantra(String[] items, int[] swap, long Lnum) {
        int N = items.length;
        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            result[i] = items[i];
        }
        // use modular arithmetic to reduce the number of swaps
        Lnum %= N;
        for (int l = 0; l < Lnum; l++) {
            String[] temp = new String[N];
            for (int i = 0; i < N; i++) {
                temp[swap[i]] = result[i];
            }
            result = temp;
        }
        return result;
    }

    // print the result array in one line
    public static void printResult(String[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}