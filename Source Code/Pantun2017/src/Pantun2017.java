import java.util.Scanner;

public class Pantun2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        // Membaca panjang pantun murid kelas 6A
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Membaca panjang pantun murid kelas 6B
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        int totalWaktu = calculateTotalTime(A, B);
        System.out.println(totalWaktu);
    }

    private static int calculateTotalTime(int[] A, int[] B) {
        int N = A.length;
        int totalWaktu = 0;

        // Menghitung total waktu yang dibutuhkan untuk setiap pasangan murid
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                totalWaktu += A[i] + B[j];
            }
        }

        return totalWaktu;
    }
}
