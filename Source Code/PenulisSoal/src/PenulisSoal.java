import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PenulisSoal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membaca jumlah kasus uji
        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            // Membaca jumlah penulis soal
            int N = input.nextInt();

            // Membaca jumlah soal yang disumbang oleh setiap penulis
            int[] S = new int[N];
            for (int j = 0; j < N; j++) {
                S[j] = input.nextInt();
            }

            // Membaca perusahaan tempat penulis soal bekerja
            int[][] C = new int[N][];
            for (int j = 0; j < N; j++) {
                int P = input.nextInt();
                C[j] = new int[P];
                for (int k = 0; k < P; k++) {
                    C[j][k] = input.nextInt();
                }
            }

            // Menghitung tingkat keragaman maksimum
            int diversity = calculateMaxDiversity(N, S, C);

            // Mencetak hasil
            System.out.println(diversity);
        }
    }

    public static int calculateMaxDiversity(int N, int[] S, int[][] C) {
        Set<Integer> owners = new HashSet<>();

        // Menambahkan pemilik soal penulis
        for (int i = 0; i < N; i++) {
            owners.add(i + 1);
        }

        // Menambahkan pemilik soal perusahaan
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C[i].length; j++) {
                owners.add(C[i][j]);
            }
        }

        // Menghitung tingkat keragaman
        return owners.size();
    }
}