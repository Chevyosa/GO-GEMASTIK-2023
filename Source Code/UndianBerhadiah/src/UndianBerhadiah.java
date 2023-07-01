import java.util.*;

public class UndianBerhadiah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membaca jumlah peserta dan nomor kupon Pak Gema
        int N = input.nextInt();
        int X = input.nextInt();

        // Membaca nomor kupon peserta
        int[] kuponPeserta = new int[N];
        for (int i = 0; i < N; i++) {
            kuponPeserta[i] = input.nextInt();
        }

        // Menghitung selisih antara nomor kupon peserta dengan nomor kupon Pak Gema
        int[] selisih = new int[N];
        for (int i = 0; i < N; i++) {
            selisih[i] = Math.abs(kuponPeserta[i] - X);
        }

        // Mencari nilai selisih minimum
        int minSelisih = Arrays.stream(selisih).min().getAsInt();

        // Menampilkan nomor kupon peserta yang memiliki selisih minimum
        for (int i = 0; i < N; i++) {
            if (selisih[i] == minSelisih) {
                System.out.println(kuponPeserta[i]);
            }
        }
    }
}
