import java.util.Scanner;

public class PasanganTerbaik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membaca jumlah kasus uji
        int T = input.nextInt();

        for (int t = 0; t < T; t++) {
            // Membaca nilai N dan M
            int N = input.nextInt();
            int M = input.nextInt();

            // Membaca elemen-elemen array A
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = input.nextInt();
            }

            // Membaca elemen-elemen array B
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                B[i] = input.nextInt();
            }

            // Membaca elemen-elemen array C
            int[] C = new int[M];
            for (int i = 0; i < M; i++) {
                C[i] = input.nextInt();
            }

            // Menghitung nilai terkecil dari f(i, j)
            int minVal = calculateMinimumValue(N, M, A, B, C);
            System.out.println(minVal);
        }
    }

    public static int calculateMinimumValue(int N, int M, int[] A, int[] B, int[] C) {
        int minVal = Integer.MAX_VALUE;

        // Melakukan perhitungan untuk setiap pasangan (i, j)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int fVal = A[i] * B[j] + C[(A[i] * B[j]) % M];
                minVal = Math.min(minVal, fVal);
            }
        }

        return minVal;
    }
}